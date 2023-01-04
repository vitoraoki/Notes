package com.example.notes.domain.model

sealed class NotePriority {
    object High : NotePriority()
    object Medium : NotePriority()
    object Low : NotePriority()
}
