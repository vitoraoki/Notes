package com.example.notes.domain.mapper

import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.model.NotePriorityUi
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NotePriorityUiToNotePriorityMapperTest {

    private val mapper = NotePriorityUiToNotePriorityMapper()

    @Test
    fun `Map NotePriorityUi_High to NotePriority_HIGH`() {
        val notePriorityUi = NotePriorityUi.High

        val actual = mapper.map(notePriorityUi)

        val expected = NotePriority.HIGH

        assertEquals(expected, actual)
    }

    @Test
    fun `Map NotePriorityUi_Medium to NotePriority_MEDIUM`() {
        val notePriorityUi = NotePriorityUi.Medium

        val actual = mapper.map(notePriorityUi)

        val expected = NotePriority.MEDIUM

        assertEquals(expected, actual)
    }

    @Test
    fun `Map NotePriorityUi_Low to NotePriority_LOW`() {
        val notePriorityUi = NotePriorityUi.Low

        val actual = mapper.map(notePriorityUi)

        val expected = NotePriority.LOW

        assertEquals(expected, actual)
    }
}