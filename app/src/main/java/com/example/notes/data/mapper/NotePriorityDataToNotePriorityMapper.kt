package com.example.notes.data.mapper

import com.example.notes.data.model.CRITICAL
import com.example.notes.data.model.MEDIUM
import com.example.notes.domain.model.NotePriority
import com.example.notes.utils.Mapper
import javax.inject.Inject

class NotePriorityDataToNotePriorityMapper @Inject constructor(): Mapper<String, NotePriority> {

    override fun map(it: String): NotePriority =
        when(it) {
            CRITICAL -> NotePriority.Critical
            MEDIUM -> NotePriority.Medium
            else -> NotePriority.Low
        }
}