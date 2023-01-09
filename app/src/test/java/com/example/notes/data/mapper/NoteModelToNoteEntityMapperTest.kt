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
    fun `Map from NoteModel to NoteEntity with default id`() {
        val noteModel = NoteModel(
            id = "",
            title = title,
            description = description,
            createdAt = createdAt,
            priority = priority
        )

        val actual = mapper.map(noteModel)

        val expected = NoteEntity(
            id = NoteEntity.DEFAULT_ID,
            title = title,
            description = description,
            createdAt = createdAt.time,
            priority = priority.name,
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `Map from NoteModel to NoteEntity with id`() {
        val id = 1L

        val noteModel = NoteModel(
            id = id.toString(),
            title = title,
            description = description,
            createdAt = createdAt,
            priority = priority
        )

        val actual = mapper.map(noteModel)

        val expected = NoteEntity(
            id = id,
            title = title,
            description = description,
            createdAt = createdAt.time,
            priority = priority.name,
        )

        assertEquals(expected, actual)
    }
}