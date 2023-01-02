package com.example.notes.presentation.model

import java.util.*

data class CreateNoteUiModel(
    val title: String,
    val description: String,
    val priority: String,
    val date: Date,
)
