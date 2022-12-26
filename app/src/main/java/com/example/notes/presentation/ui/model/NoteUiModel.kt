package com.example.notes.presentation.ui.model

import java.util.Date

data class NoteUiModel(
    val title: String,
    val description: String,
    val date: Date,
    val priority: NotePriorityUi,
)
