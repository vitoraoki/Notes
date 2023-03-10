package com.example.notes.domain.mapper

import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.model.CreateNoteUiModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

internal class CreateNoteUiModelToNoteModelMapperTest {

    private val mapper = CreateNoteUiModelToNoteModelMapper()

    private val title = "title"
    private val description = "description"
    private val createdAt = Date()
    private val priority = NotePriority.HIGH

    @Test
    fun `Map CreateNoteUiModel to NoteModel`() {
        val createNoteUiModel = CreateNoteUiModel(
            title = title,
            description = description,
            createdAt = createdAt,
            priority = priority.name,
        )

        val actual = mapper.map(createNoteUiModel)

        val expected = NoteModel(
            title = title,
            description = description,
            createdAt = createdAt,
            priority = priority,
        )

        assertEquals(expected, actual)
    }
}