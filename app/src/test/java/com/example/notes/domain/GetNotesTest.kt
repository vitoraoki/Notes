package com.example.notes.domain

import com.example.notes.data.repository.NotesRepository
import com.example.notes.domain.model.NoteModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GetNotesTest {

    private val notesRepository: NotesRepository = mockk()

    private val useCase = GetNotes(notesRepository)

    @Test
    fun `Verify call getNotes from notesRepository`() {
        mock()

        useCase()

        verify(exactly = 1) { notesRepository.getNotes() }
    }

    @Test
    fun `Assert list of NoteModels`() {
        val expected: List<NoteModel> = listOf(mockk(), mockk())
        mock(expected)

        val actual = useCase()

        assertEquals(expected, actual)
    }

    private fun mock(notes: List<NoteModel> = listOf()) {
        every { notesRepository.getNotes() } returns notes
    }
}