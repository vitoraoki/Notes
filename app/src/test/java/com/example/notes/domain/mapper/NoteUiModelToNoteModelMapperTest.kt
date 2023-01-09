package com.example.notes.domain.mapper

import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.model.NotePriorityUi
import com.example.notes.presentation.model.NoteUiModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Date

internal class NoteUiModelToNoteModelMapperTest {

    private val notePriorityMapper: NotePriorityUiToNotePriorityMapper = mockk()

    private val mapper = NoteUiModelToNoteModelMapper(notePriorityMapper)

    private val id = "id"
    private val title = "title"
    private val description = "description"
    private val createdAt = Date()

    @Test
    fun `Verify call of notePriorityMapper`() {
        val priorityUi = NotePriorityUi.High
        mock()

        val noteUiModel = NoteUiModel(
            id = id,
            title = title,
            description = description,
            createdAt = createdAt,
            priority = priorityUi,
        )

        mapper.map(noteUiModel)

        verify(exactly = 1) {
            notePriorityMapper.map(priorityUi)
        }
    }

    @Test
    fun `Assert map from NoteUiModel to NoteModel`() {
        val notePriority = NotePriority.HIGH
        mock(notePriority)

        val noteUiModel = NoteUiModel(
            id = id,
            title = title,
            description = description,
            createdAt = createdAt,
            priority = NotePriorityUi.High,
        )

        val actual = mapper.map(noteUiModel)

        val expected = NoteModel(
            id = id,
            title = title,
            description = description,
            createdAt = createdAt,
            priority = notePriority,
        )

        assertEquals(expected, actual)
    }

    private fun mock(notePriority: NotePriority = NotePriority.HIGH) {
        every { notePriorityMapper.map(any()) } returns notePriority
    }
}