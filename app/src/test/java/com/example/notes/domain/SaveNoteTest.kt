package com.example.notes.domain

import com.example.notes.data.repository.NotesRepository
import com.example.notes.domain.mapper.CreateNoteUiModelToNoteModelMapper
import com.example.notes.domain.model.NoteModel
import com.example.notes.presentation.model.CreateNoteUiModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SaveNoteTest {

    private val noteModelMapper: CreateNoteUiModelToNoteModelMapper = mockk()
    private val repository: NotesRepository = mockk()

    private val useCase = SaveNote(
        noteModelMapper = noteModelMapper,
        repository = repository
    )

    @Test
    fun `Verify calls of noteModelMapper and saveNote`() {
        val createNoteUiModel: CreateNoteUiModel = mockk()
        val noteModel: NoteModel = mockk()
        mock(noteModel = noteModel)

        useCase(createNoteUiModel)

        verify(exactly = 1) {
            noteModelMapper.map(createNoteUiModel)
            repository.saveNote(noteModel)
        }
    }

    @Test
    fun `Assert saveNote result`() {
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
        every { repository.saveNote(any()) } returns saveNoteResult
    }

    private fun randomResult(): Boolean = listOf(true, false).random()
}