package com.example.notes.presentation.mapper

import com.example.notes.base.TestBase
import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.model.NotePriorityUi
import com.example.notes.presentation.model.NoteUiModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

internal class NoteModelToNoteUiModelMapperTest: TestBase() {

    private val notePriorityUiMapper: NotePriorityToNotePriorityUiMapper = mockk()

    private val mapper = NoteModelToNoteUiModelMapper(notePriorityUiMapper)

    private val title = "title"
    private val description = "description"
    private val date = Date()

    @Test
    fun `Verify call notePriorityUiMapper`() {
        mock()

        val noteModel = NoteModel(
            title = title,
            description = description,
            date = date,
            priority = NotePriority.High
        )

        mapper.map(noteModel)

        verify(exactly = 1) {
            notePriorityUiMapper.map(noteModel.priority)
        }
    }

    @Test
    fun `Assert NoteUiModel from mapper`() {
        val priority: NotePriorityUi = NotePriorityUi.High
        mock(priority)

        val noteModel = NoteModel(
            title = title,
            description = description,
            date = date,
            priority = NotePriority.High
        )

        val actual = mapper.map(noteModel)

        val expected = NoteUiModel(
            title = title,
            description = description,
            date = date,
            priority = priority
        )

        assertEquals(expected, actual)
    }

    private fun mock(priority: NotePriorityUi = mockk()) {
        every { notePriorityUiMapper.map(any()) } returns priority
    }
}