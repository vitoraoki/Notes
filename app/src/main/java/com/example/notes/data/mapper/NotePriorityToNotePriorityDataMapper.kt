package com.example.notes.data.mapper

import com.example.notes.data.model.HIGH
import com.example.notes.data.model.LOW
import com.example.notes.data.model.MEDIUM
import com.example.notes.domain.model.NotePriority
import com.example.notes.utils.Mapper
import javax.inject.Inject

class NotePriorityToNotePriorityDataMapper @Inject constructor(): Mapper<NotePriority, String> {

    override fun map(it: NotePriority): String =
        when(it) {
            is NotePriority.High -> HIGH
            is NotePriority.Medium -> MEDIUM
            is NotePriority.Low -> LOW
        }
}