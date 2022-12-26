package com.example.notes.data.mapper

import com.example.notes.data.model.CRITICAL
import com.example.notes.data.model.MEDIUM
import com.example.notes.domain.model.NotePriority

class NotePriorityDataToNotePriorityMapper {
    fun map(priority: String): NotePriority =
        when(priority) {
            CRITICAL -> NotePriority.Critical
            MEDIUM -> NotePriority.Medium
            else -> NotePriority.Low
        }
}