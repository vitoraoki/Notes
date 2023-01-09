package com.example.notes.domain.usecase

import com.example.notes.presentation.model.NotePriorityUi
import com.example.notes.presentation.model.NoteUiModel
import com.example.notes.presentation.model.SortAction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

internal class SortNotesListTest {

    private val useCase = SortNotesList()

    private val noteUiModel1 = NoteUiModel(
        id = "id1",
        title = "title1",
        description = "description1",
        createdAt = Date(1),
        priority = NotePriorityUi.High,
    )
    private val noteUiModel2 = NoteUiModel(
        id = "id2",
        title = "title2",
        description = "description2",
        createdAt = Date(2),
        priority = NotePriorityUi.Medium,
    )

    @Test
    fun `With SORT_BY_CREATED_AT_ASC return ascending sorted list`() {
        val sortAction = SortAction.SORT_BY_CREATED_AT_ASC
        val notes = listOf(noteUiModel2, noteUiModel1)

        val actual = useCase(notes, sortAction)

        val expected = listOf(noteUiModel1, noteUiModel2)

        assertEquals(expected, actual)
    }

    @Test
    fun `With SORT_BY_CREATED_AT_DESC return descending sorted list`() {
        val sortAction = SortAction.SORT_BY_CREATED_AT_DESC
        val notes = listOf(noteUiModel1, noteUiModel2)

        val actual = useCase(notes, sortAction)

        val expected = listOf(noteUiModel2, noteUiModel1)

        assertEquals(expected, actual)
    }

    @Test
    fun `With SORT_BY_TITLE_ASC return ascending sorted list`() {
        val sortAction = SortAction.SORT_BY_TITLE_ASC
        val notes = listOf(noteUiModel2, noteUiModel1)

        val actual = useCase(notes, sortAction)

        val expected = listOf(noteUiModel1, noteUiModel2)

        assertEquals(expected, actual)
    }

    @Test
    fun `With SORT_BY_TITLE_DESC return descending sorted list`() {
        val sortAction = SortAction.SORT_BY_TITLE_DESC
        val notes = listOf(noteUiModel1, noteUiModel2)

        val actual = useCase(notes, sortAction)

        val expected = listOf(noteUiModel2, noteUiModel1)

        assertEquals(expected, actual)
    }
}