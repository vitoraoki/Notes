package com.example.notes.data.mapper

import com.example.notes.data.model.CRITICAL
import com.example.notes.data.model.MEDIUM
import com.example.notes.domain.model.NotePriority
import javax.inject.Inject

class NotePriorityDataToNotePriorityMapper @Inject constructor() {

    fun map(priority: String): NotePriority =
        when(priority) {
            CRITICAL -> NotePriority.Critical
            MEDIUM -> NotePriority.Medium
            else -> NotePriority.Low
        }
}