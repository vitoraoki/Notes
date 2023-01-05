package com.example.notes.presentation.createnote

import com.example.notes.base.TestBase
import com.example.notes.domain.SaveNoteUseCase
import com.example.notes.presentation.model.CreateNoteUiModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CreateNoteViewModelTest: TestBase() {

    private val saveNoteUseCase: SaveNoteUseCase = mockk()

    private val viewModel = CreateNoteViewModel(saveNoteUseCase)

    @Test
    fun `Verify call saveNoteUseCase`() {
        mock()
        val createNoteUiModel: CreateNoteUiModel = mockk()

        viewModel.saveNote(createNoteUiModel)

        verify(exactly = 1) {
            saveNoteUseCase(createNoteUiModel)
        }
    }

    @Test
    fun `Assert saveNote result`() {
        val expected = randomResult()
        mock(saveNoteResult = expected)

        val actual = viewModel.saveNote(mockk())

        assertEquals(expected, actual)
    }

    private fun mock(saveNoteResult: Boolean = randomResult()) {
        every { saveNoteUseCase(any()) } returns saveNoteResult
    }
}