package com.example.notes.presentation.mapper

import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.ui.model.NotePriorityUi

class NotePriorityToNotePriorityUiMapper {
    fun map(notePriority: NotePriority): NotePriorityUi =
        when(notePriority) {
            NotePriority.Critical -> NotePriorityUi.Critical
            NotePriority.Medium -> NotePriorityUi.Medium
            NotePriority.Low -> NotePriorityUi.Low
        }
}