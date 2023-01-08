package com.example.notes.data.repository

import com.example.notes.base.TestBase
import com.example.notes.data.database.dao.NotesDao
import com.example.notes.data.database.entities.NoteEntity
import com.example.notes.data.mapper.NoteEntityToNoteModelMapper
import com.example.notes.data.mapper.NoteModelToNoteEntityMapper
import com.example.notes.domain.model.NoteModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class NotesRepositoryImplTest {

    private val notesDao: NotesDao = mockk()
    private val noteEntityMapper: NoteModelToNoteEntityMapper = mockk()
    private val noteModelMapper: NoteEntityToNoteModelMapper = mockk()

    private val repository = NotesRepositoryImpl(
        notesDao = notesDao,
        noteEntityMapper = noteEntityMapper,
        noteModelMapper = noteModelMapper,
    )

    @Test
    fun `Verify calls createNote`() = runTest {
        val noteModel: NoteModel = mockk()
        val noteEntity: NoteEntity = mockk()
        mockCreateNote(noteEntity = noteEntity)

        repository.createNote(noteModel)

        coVerify(exactly = 1) {
            noteEntityMapper.map(noteModel)
            notesDao.createNote(noteEntity)
        }
    }

    @Test
    fun `Create note with success return true`() = runTest {
        val noteEntity: NoteEntity = mockk()
        mockCreateNote(noteEntity = noteEntity)

        val actual = repository.createNote(mockk())

        assertTrue(actual)
    }

    @Test
    fun `Create note with error return false`() = runTest {
        mockCreateNote(createNoteException = Exception())

        val actual = repository.createNote(mockk())

        assertFalse(actual)
    }

    @Test
    fun `Verify calls getNotes`() = runTest {
        val noteEntity: NoteEntity = mockk()
        val noteEntities: List<NoteEntity> = listOf(noteEntity)
        mockGetNotes(noteEntities = noteEntities)

        repository.getNotes()

        coVerify(exactly = 1) {
            notesDao.getAllNotesOrderedByCreatedAt()
            noteModelMapper.map(noteEntity)
        }
    }

    @Test
    fun `Get notes with success return list of NoteModel`() = runTest {
        val noteEntity: NoteEntity = mockk()
        val noteEntities: List<NoteEntity> = listOf(noteEntity)
        val noteModel: NoteModel = mockk()
        mockGetNotes(noteEntities = noteEntities, noteModel = noteModel)

        val actual = repository.getNotes()

        val expected = listOf(noteModel)

        assertEquals(expected, actual)
    }

    @Test
    fun `Get notes with error return empty list`() = runTest {
        mockGetNotes(getNotesException = Exception())

        val actual = repository.getNotes()

        val expected: List<NoteModel> = listOf()

        assertEquals(expected, actual)
    }

    private fun mockCreateNote(
        createNoteException: Exception? = null,
        noteEntity: NoteEntity = mockk(),
    ) {
        createNoteException?.let { exception ->
            coEvery { notesDao.createNote(any()) } throws exception
        } ?: run {
            coEvery { notesDao.createNote(any()) } just runs
        }
        every { noteEntityMapper.map(any()) } returns noteEntity
    }

    private fun mockGetNotes(
        getNotesException: Exception? = null,
        noteEntities: List<NoteEntity> = listOf(mockk()),
        noteModel: NoteModel = mockk(),
    ) {
        getNotesException?.let { exception ->
            coEvery { notesDao.getAllNotesOrderedByCreatedAt() } throws exception
        } ?: run {
            coEvery { notesDao.getAllNotesOrderedByCreatedAt() } returns noteEntities
        }
        every { noteModelMapper.map(any()) } returns noteModel
    }
}