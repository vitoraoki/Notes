package com.example.notes.presentation.createnote

import com.example.notes.base.TestBase
import com.example.notes.domain.usecase.CreateNoteUseCase
import com.example.notes.extensions.TestCoroutineExtension
import com.example.notes.presentation.model.CreateNoteUiModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(TestCoroutineExtension::class)
internal class CreateNoteViewModelTest: TestBase() {

    private val createNoteUseCase: CreateNoteUseCase = mockk()

    private val viewModel = CreateNoteViewModel(createNoteUseCase)

    @Test
    fun `Verify call createNoteUseCase`() = runTest {
        mock()
        val createNoteUiModel: CreateNoteUiModel = mockk()

        viewModel.createNote(createNoteUiModel)

        coVerify(exactly = 1) {
            createNoteUseCase(createNoteUiModel)
        }
    }

    @Test
    fun `Assert createNote result`() = runTest {
        val expected = randomBoolean()
        mock(saveNoteResult = expected)

        viewModel.createNote(mockk())
        val actual = viewModel.saveNoteResult.first()

        assertEquals(expected, actual)
    }

    private fun mock(saveNoteResult: Boolean = randomBoolean()) {
        coEvery { createNoteUseCase(any()) } returns saveNoteResult
    }
}