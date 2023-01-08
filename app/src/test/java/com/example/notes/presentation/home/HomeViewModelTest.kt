package com.example.notes.presentation.home

import com.example.notes.base.TestBase
import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.usecase.GetNotesUseCase
import com.example.notes.domain.usecase.SortNotesListUseCase
import com.example.notes.extensions.TestCoroutineExtension
import com.example.notes.presentation.mapper.NoteModelToNoteUiModelMapper
import com.example.notes.presentation.model.NoteUiModel
import com.example.notes.presentation.model.SortAction
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(TestCoroutineExtension::class)
internal class HomeViewModelTest: TestBase() {

    private val getNotesUseCase: GetNotesUseCase = mockk()
    private val noteModelUiMapper: NoteModelToNoteUiModelMapper = mockk()
    private val sortNotesList: SortNotesListUseCase = mockk()

    private val viewModel = HomeViewModel(
        getNotesUseCase = getNotesUseCase,
        noteModelUiMapper = noteModelUiMapper,
        sortNotesList = sortNotesList,
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

    @Test
    fun `With empty list verify do not call sortNotesList`() {
        val sortAction: SortAction = randomEnum()

        viewModel.sortNotes(sortAction)

        verify(exactly = 0) {
            sortNotesList(any(), any())
        }
    }

    @Test
    fun `With filled notes list verify call`() {
        val noteUiModel: NoteUiModel = mockk()
        val sortAction: SortAction = randomEnum()
        mock(noteUiModel = noteUiModel)

        viewModel.getNotes()
        viewModel.sortNotes(sortAction)

        verify(exactly = 1) {
            sortNotesList(listOf(noteUiModel), sortAction)
        }
    }

    @Test
    fun `With filled notes list return sorted list`() = runTest {
        val expected: List<NoteUiModel> = listOf(mockk())
        val sortAction: SortAction = randomEnum()
        mock(notesUiModel = expected)

        viewModel.getNotes()
        viewModel.sortNotes(sortAction)
        val actual = viewModel.notesFlow.first()

        assertEquals(expected, actual)
    }

    private fun mock(
        notesModel: List<NoteModel> = listOf(mockk()),
        noteUiModel: NoteUiModel = mockk(),
        notesUiModel: List<NoteUiModel> = listOf(mockk()),
    ) {
        coEvery { getNotesUseCase() } returns notesModel
        every { noteModelUiMapper.map(any()) } returns noteUiModel
        every { sortNotesList(any(), any()) } returns notesUiModel
    }
}