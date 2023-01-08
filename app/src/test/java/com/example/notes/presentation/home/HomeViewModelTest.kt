package com.example.notes.presentation.home

import com.example.notes.domain.GetNotesUseCase
import com.example.notes.domain.model.NoteModel
import com.example.notes.extensions.TestCoroutineExtension
import com.example.notes.presentation.mapper.NoteModelToNoteUiModelMapper
import com.example.notes.presentation.model.NoteUiModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(TestCoroutineExtension::class)
internal class HomeViewModelTest {

    private val getNotesUseCase: GetNotesUseCase = mockk()
    private val noteModelUiMapper: NoteModelToNoteUiModelMapper = mockk()

    private val viewModel = HomeViewModel(
        getNotesUseCase = getNotesUseCase,
        noteModelUiMapper = noteModelUiMapper
    )



    @Test
    fun `Verify calls getNotesUseCase and noteModelUiMapper`() = runTest {
        val noteModel: NoteModel = mockk()
        val notesModel: List<NoteModel> = listOf(noteModel)
        mock(notesModel = notesModel)

        viewModel.getNotes()

        coVerify(exactly = 1) {
            getNotesUseCase()
            noteModelUiMapper.map(noteModel)
        }
    }

    @Test
    fun `Assert notesFlow values`() = runTest {
        val noteModel: NoteModel = mockk()
        val noteUiModel: NoteUiModel = mockk()
        mock(notesModel = listOf(noteModel), noteUiModel = noteUiModel)

        viewModel.getNotes()
        val actual = viewModel.notesFlow.first()

        val expected = listOf(noteUiModel)

        assertEquals(expected, actual)
    }

    private fun mock(
        notesModel: List<NoteModel> = listOf(mockk()),
        noteUiModel: NoteUiModel = mockk()
    ) {
        coEvery { getNotesUseCase() } returns notesModel
        every { noteModelUiMapper.map(any()) } returns noteUiModel
    }
}