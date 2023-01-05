package com.example.notes.domain.mapper

import com.example.notes.data.mapper.NotePriorityDataToNotePriorityMapper
import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.model.CreateNoteUiModel
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

internal class CreateNoteUiModelToNoteModelMapperTest {

    private val notePriorityMapper: NotePriorityDataToNotePriorityMapper = mockk()

    private val mapper = CreateNoteUiModelToNoteModelMapper(notePriorityMapper)

    private val title = "title"
    private val description = "description"
    private val date = Date()
    private val priority = NotePriority.High

    @Test
    fun `Map CreateNoteUiModel to NoteModel`() {
        mock(priority)

        val createNoteUiModel = CreateNoteUiModel(
            title = title,
            description = description,
            date = date,
            priority = "priority",
        )

        val actual = mapper.map(createNoteUiModel)

        val expected = NoteModel(
            title = title,
            description = description,
            date = date,
            priority = priority,
        )

        assertEquals(expected, actual)
    }

    private fun mock(notePriority: NotePriority = NotePriority.High) {
        every { notePriorityMapper.map(any()) } returns notePriority
    }
}