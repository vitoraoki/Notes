package com.example.notes.data.model

const val CRITICAL = "CRITICAL"
const val MEDIUM = "MEDIUM"
const val LOW = "LOW"

data class NoteData(
    val id: String,
    val title: String,
    val description: String,
    val date: Long,
    val priority: String,
)