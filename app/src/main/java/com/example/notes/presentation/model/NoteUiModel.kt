package com.example.notes.presentation.model

import java.util.*

data class NoteUiModel(
    val title: String,
    val description: String,
    val date: Date,
    val priority: NotePriorityUi,
)
