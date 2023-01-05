package com.example.notes.data.mapper

import com.example.notes.data.model.NoteData
import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.Date

internal class NoteDataToNoteModelMapperTest {

    private val notePriorityMapper: NotePriorityDataToNotePriorityMapper = mockk()

    private val mapper = NoteDataToNoteModelMapper(notePriorityMapper)

    private val id = "id"
    private val title = "title"
    private val description = "description"
    private val date = Date()

    @Test
    fun `Map from NoteData to NoteModel`() {
        val priority = NotePriority.High
        mock(priority = priority)

        val noteData = NoteData(
            id = id,
            title = title,
            description = description,
            date = date.time,
            priority = priority.toString(),
        )

        val actual = mapper.map(noteData)

        val expected = NoteModel(
            id = id,
            title = title,
            description = description,
            date = date,
            priority = priority,
        )

        assertEquals(expected, actual)
    }

    private fun mock(priority: NotePriority = NotePriority.High) {
        every { notePriorityMapper.map(any()) } returns priority
    }
}
