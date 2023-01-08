package com.example.notes.domain.usecase

import com.example.notes.data.repository.NotesRepository
import com.example.notes.domain.model.NoteModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class GetNotesTest {

    private val notesRepository: NotesRepository = mockk()

    private val useCase = GetNotes(notesRepository)

    @Test
    fun `Verify call invoke`() = runTest {
        mock()

        useCase()

        coVerify(exactly = 1) { notesRepository.getNotes() }
    }

    @Test
    fun `Assert list of NoteModels`() = runTest {
        val expected: List<NoteModel> = listOf(mockk(), mockk())
        mock(expected)

        val actual = useCase()

        assertEquals(expected, actual)
    }

    private fun mock(notes: List<NoteModel> = listOf()) {
        coEvery { notesRepository.getNotes() } returns notes
    }
}