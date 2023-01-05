package com.example.notes.data.mapper

import com.example.notes.data.model.HIGH
import com.example.notes.data.model.LOW
import com.example.notes.data.model.MEDIUM
import com.example.notes.domain.model.NotePriority
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NotePriorityDataToNotePriorityMapperTest {

    private val mapper = NotePriorityDataToNotePriorityMapper()

    @Test
    fun `Map HIGH priority to NotePriority High`() {
        val priorityData = HIGH

        val actual = mapper.map(priorityData)

        val expected = NotePriority.High

        assertEquals(expected, actual)
    }

    @Test
    fun `Map MEDIUM priority to NotePriority Medium`() {
        val priorityData = MEDIUM

        val actual = mapper.map(priorityData)

        val expected = NotePriority.Medium

        assertEquals(expected, actual)
    }

    @Test
    fun `Map LOW priority or other string to NotePriority Low`() {
        val priorityDataList = listOf(LOW, "priority1", "priority2")

        val actual = mapper.map(priorityDataList.random())

        val expected = NotePriority.Low

        assertEquals(expected, actual)
    }
}