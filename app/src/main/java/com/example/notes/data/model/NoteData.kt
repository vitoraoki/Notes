package com.example.notes.data.model

const val HIGH = "HIGH"
const val MEDIUM = "MEDIUM"
const val LOW = "LOW"

data class NoteData(
    val id: String,
    val title: String,
    val description: String,
    val date: Long,
    val priority: String,
)

fun getPriorityList(): List<String> = listOf(HIGH, MEDIUM, LOW)