package com.example.notes.domain.usecase

import com.example.notes.base.TestBase
import com.example.notes.data.repository.NotesRepository
import com.example.notes.domain.mapper.NoteUiModelToNoteModelMapper
import com.example.notes.domain.model.NoteModel
import com.example.notes.presentation.model.NoteUiModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

@ExperimentalCoroutinesApi
internal class DeleteNoteTest: TestBase() {

    private val noteModelMapper: NoteUiModelToNoteModelMapper = mockk()
    private val repository: NotesRepository = mockk()

    private val useCase = DeleteNote(
        noteModelMapper = noteModelMapper,
        repository = repository,
    )

    @Test
    fun `Verify calls of noteModelMapper and deleteNote from repository`() = runTest {
        val noteModel: NoteModel = mockk()
        val noteUiModel: NoteUiModel = mockk()
        mock(noteModel = noteModel)

        useCase(noteUiModel)

        coVerify(exactly = 1) {
            noteModelMapper.map(noteUiModel)
            repository.deleteNote(noteModel)
        }
    }

    @Test
    fun `Assert result for delete note`() = runTest {
        val expected = randomBoolean()
        mock(deleteNoteResult = expected)

        val actual = useCase(mockk())

        assertEquals(expected, actual)
    }

    private fun mock(
        noteModel: NoteModel = mockk(),
        deleteNoteResult: Boolean = randomBoolean(),
    ) {
        every { noteModelMapper.map(any()) } returns noteModel
        coEvery { repository.deleteNote(any()) } returns deleteNoteResult
    }
}