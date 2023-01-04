package com.example.notes.data.mapper

import com.example.notes.data.model.HIGH
import com.example.notes.data.model.NoteData
import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Date

class NoteModelToNoteDataMapperTest {

    private val notePriorityDataMapper: NotePriorityToNotePriorityDataMapper = mockk()

    private val mapper = NoteModelToNoteDataMapper(notePriorityDataMapper)

    private val id = "id"
    private val title = "title"
    private val description = "description"
    private val date = Date()

    @Test
    fun `Map from storage id and NoteModel to NoteData`() {
        val priority = HIGH
        mock(priority)

        val noteModel = NoteModel(
            id = "id",
            title = title,
            description = description,
            date = date,
            priority = NotePriority.High,
        )

        val actual = mapper.map(id, noteModel)

        val expected = NoteData(
            id = id,
            title = title,
            description = description,
            date = date.time,
            priority = priority,
        )

        assertEquals(expected, actual)
    }

    private fun mock(priority: String) {
        every { notePriorityDataMapper.map(any()) } returns priority
    }
}