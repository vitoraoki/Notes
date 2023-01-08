package com.example.notes.presentation.mapper
//
//import com.example.notes.domain.model.NotePriority
//import com.example.notes.presentation.model.NotePriorityUi
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Test
//
//internal class NotePriorityToNotePriorityUiMapperTest {
//
//    private val mapper = NotePriorityToNotePriorityUiMapper()
//
//    @Test
//    fun `With NotePriority High return NotePriorityUi High`() {
//        val notePriority = NotePriority.High
//
//        val actual = mapper.map(notePriority)
//
//        val expected = NotePriorityUi.High
//
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun `With NotePriority Medium return NotePriorityUi Medium`() {
//        val notePriority = NotePriority.Medium
//
//        val actual = mapper.map(notePriority)
//
//        val expected = NotePriorityUi.Medium
//
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun `With NotePriority Low return NotePriorityUi Low`() {
//        val notePriority = NotePriority.Low
//
//        val actual = mapper.map(notePriority)
//
//        val expected = NotePriorityUi.Low
//
//        assertEquals(expected, actual)
//    }
//}