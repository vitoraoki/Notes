package com.example.notes.data.mapper

import com.example.notes.data.database.entities.NoteEntity
import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

internal class NoteEntityToNoteModelMapperTest {

    private val mapper = NoteEntityToNoteModelMapper()

    private val id = 1L
    private val title = "title"
    private val description = "description"
    private val date = Date()

    @Test
    fun `Map from NoteData to NoteModel`() {
        val priority = NotePriority.HIGH

        val noteEntity = NoteEntity(
            id = id,
            title = title,
            description = description,
            createdAt = date.time,
            priority = priority.name,
        )

        val actual = mapper.map(noteEntity)

        val expected = NoteModel(
            id = id.toString(),
            title = title,
            description = description,
            createdAt = date,
            priority = priority,
        )

        assertEquals(expected, actual)
    }
}
