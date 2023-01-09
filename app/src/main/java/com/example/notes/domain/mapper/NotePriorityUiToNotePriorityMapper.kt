package com.example.notes.domain.mapper

import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.model.NotePriorityUi
import com.example.notes.utils.Mapper
import javax.inject.Inject

class NotePriorityUiToNotePriorityMapper @Inject constructor() :
    Mapper<NotePriorityUi, NotePriority> {

    override fun map(it: NotePriorityUi): NotePriority =
        when(it) {
            is NotePriorityUi.High -> NotePriority.HIGH
            is NotePriorityUi.Medium -> NotePriority.MEDIUM
            is NotePriorityUi.Low -> NotePriority.LOW
        }
}