package com.example.notes.presentation.model

import androidx.compose.ui.graphics.Color

sealed class NotePriorityUi {
    abstract val backgroundColor: Color
    abstract val strokeColor: Color

    data class High(
        override val backgroundColor: Color = Color(0xFFFF7777),
        override val strokeColor: Color = Color(0xFFFF0000),
    ) : NotePriorityUi()

    data class Medium(
        override val backgroundColor: Color = Color(0xFFFFC15C),
        override val strokeColor: Color = Color(0xFFFF9E00),
    ) : NotePriorityUi()

    data class Low(
        override val backgroundColor: Color = Color(0xFF8ECB7D),
        override val strokeColor: Color = Color(0xFF2EC900),
    ) : NotePriorityUi()

    companion object {
        val High: High
            get() = High()

        val Medium: Medium
            get() = Medium()

        val Low: Low
            get() = Low()
    }
}
