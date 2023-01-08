package com.example.notes.data.mapper
//
//import com.example.notes.data.model.HIGH
//import com.example.notes.data.model.LOW
//import com.example.notes.data.model.MEDIUM
//import com.example.notes.domain.model.NotePriority
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Test
//
//internal class NotePriorityToNotePriorityDataMapperTest {
//
//    private val mapper = NotePriorityToNotePriorityDataMapper()
//
//    @Test
//    fun `Map NotePriority High to HIGH priority`() {
//        val notePriority = NotePriority.High
//
//        val actual = mapper.map(notePriority)
//
//        val expected = HIGH
//
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun `Map NotePriority Medium to MEDIUM priority`() {
//        val notePriority = NotePriority.Medium
//
//        val actual = mapper.map(notePriority)
//
//        val expected = MEDIUM
//
//        assertEquals(expected, actual)
//    }
//    @Test
//    fun `Map NotePriority Low to LOW priority`() {
//        val notePriority = NotePriority.Low
//
//        val actual = mapper.map(notePriority)
//
//        val expected = LOW
//
//        assertEquals(expected, actual)
//    }
//}