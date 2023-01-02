package com.example.notes.domain.model

import java.util.*

data class NoteModel(
    val id: String = "",
    val title: String,
    val description: String,
    val date: Date,
    val priority: NotePriority,
)
