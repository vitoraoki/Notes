package com.example.notes.domain.usecase

import com.example.notes.data.repository.NotesRepository
import com.example.notes.domain.mapper.CreateNoteUiModelToNoteModelMapper
import com.example.notes.domain.model.NoteModel
import com.example.notes.presentation.model.CreateNoteUiModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class CreateNoteTest {

    private val noteModelMapper: CreateNoteUiModelToNoteModelMapper = mockk()
    private val repository: NotesRepository = mockk()

    private val useCase = CreateNote(
        noteModelMapper = noteModelMapper,
        repository = repository
    )

    @Test
    fun `Verify calls invoke`() = runTest {
        val createNoteUiModel: CreateNoteUiModel = mockk()
        val noteModel: NoteModel = mockk()
        mock(noteModel = noteModel)

        useCase(createNoteUiModel)

        coVerify (exactly = 1) {
            noteModelMapper.map(createNoteUiModel)
            repository.createNote(noteModel)
        }
    }

    @Test
    fun `Assert saveNote result`() = runTest {
        val expected = randomResult()
        mock(saveNoteResult = expected)

        val actual = useCase(mockk())

        assertEquals(expected, actual)
    }

    private fun mock(
        noteModel: NoteModel = mockk(),
        saveNoteResult: Boolean = randomResult()
    ) {
        every { noteModelMapper.map(any()) } returns noteModel
        coEvery { repository.createNote(any()) } returns saveNoteResult
    }

    private fun randomResult(): Boolean = listOf(true, false).random()
}