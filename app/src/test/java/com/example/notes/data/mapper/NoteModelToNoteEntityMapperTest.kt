package com.example.notes.data.mapper

import com.example.notes.data.database.entities.NoteEntity
import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class NoteModelToNoteEntityMapperTest {

    private val mapper = NoteModelToNoteEntityMapper()

    private val title = "title"
    private val description = "description"
    private val createdAt = Date()
    private val priority = NotePriority.HIGH

    @Test
    fun `Map from NoteModel to NoteEntity`() {
        val noteModel = NoteModel(
            title = title,
            description = description,
            createdAt = createdAt,
            priority = priority
        )

        val actual = mapper.map(noteModel)

        val expected = NoteEntity(
            title = title,
            description = description,
            createdAt = createdAt.time,
            priority = priority.name,
        )

        assertEquals(expected, actual)
    }
}