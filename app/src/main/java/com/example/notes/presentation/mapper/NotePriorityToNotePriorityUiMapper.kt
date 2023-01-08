package com.example.notes.presentation.mapper

import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.model.NotePriorityUi
import javax.inject.Inject

class NotePriorityToNotePriorityUiMapper @Inject constructor() {

    fun map(notePriority: NotePriority): NotePriorityUi =
        when(notePriority) {
            NotePriority.HIGH -> NotePriorityUi.High
            NotePriority.MEDIUM -> NotePriorityUi.Medium
            NotePriority.LOW -> NotePriorityUi.Low
        }
}