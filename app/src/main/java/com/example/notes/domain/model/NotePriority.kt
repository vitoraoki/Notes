package com.example.notes.domain.model

enum class NotePriority {
    HIGH,
    MEDIUM,
    LOW;

    companion object {

        fun fromString(priority: String) =
            values().find { it.name.equals(priority, true) } ?: LOW

        fun getPriorities(): List<NotePriority> = listOf(HIGH, MEDIUM, LOW)
    }
}
