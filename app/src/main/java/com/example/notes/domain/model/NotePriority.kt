package com.example.notes.domain.model

sealed class NotePriority {
    object Critical : NotePriority()
    object Medium : NotePriority()
    object Low : NotePriority()
}
