package com.example.notes.presentation.model

import java.util.*

data class NoteUiModel(
    val id: String,
    val title: String,
    val description: String,
    val createdAt: Date,
    val priority: NotePriorityUi,
)
