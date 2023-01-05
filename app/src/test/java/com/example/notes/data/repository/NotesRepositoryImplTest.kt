package com.example.notes.data.repository

import com.example.notes.base.TestBase
import com.example.notes.data.database.NotesDataBase
import com.example.notes.data.mapper.NoteDataToNoteModelMapper
import com.example.notes.data.model.NoteData
import com.example.notes.domain.model.NoteModel
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NotesRepositoryImplTest: TestBase() {

    private val notesDataBase: NotesDataBase = mockk()
    private val noteModelMapper: NoteDataToNoteModelMapper = mockk()

    private val repository = NotesRepositoryImpl(
        notesDataBase = notesDataBase,
        noteModelMapper = noteModelMapper
    )

    @Test
    fun `Verify call of saveNote database function`() {
        mock()
        val noteModel: NoteModel = mockk()

        repository.saveNote(noteModel)

        verify(exactly = 1) { notesDataBase.saveNote(noteModel) }
    }

    @Test
    fun `Assert saveNote result`() {
        val expected = randomResult()
        mock(saveNotesResult = expected)

        val actual = repository.saveNote(mockk())

        assertEquals(expected, actual)
    }

    @Test
    fun `Verify calls of getNotes and noteModelMapper`() {
        val noteData: NoteData = mockk()
        mock(notesData = listOf(noteData))

        repository.getNotes()

        verify(exactly = 1) {
            notesDataBase.getNotes()
            noteModelMapper.map(noteData)
        }
    }

    @Test
    fun `Assert list of NoteModels`() {
        val noteData: NoteData = mockk()
        val noteModel: NoteModel = mockk()
        mock(notesData = listOf(noteData), noteModel = noteModel)

        val actual = repository.getNotes()

        val expected = listOf(noteModel)

        assertEquals(expected, actual)
    }

    private fun mock(
        saveNotesResult: Boolean = randomResult(),
        notesData: List<NoteData> = listOf(mockk()),
        noteModel: NoteModel = mockk()
    ) {
        every { notesDataBase.saveNote(any()) } returns saveNotesResult
        every { notesDataBase.getNotes() } returns notesData
        every { noteModelMapper.map(any()) } returns noteModel
    }
}