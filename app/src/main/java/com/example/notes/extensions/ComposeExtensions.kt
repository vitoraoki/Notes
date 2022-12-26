package com.example.notes.extensions

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

fun Modifier.tapGestures(
    onClick: () -> Unit,
    onLongClick: () -> Unit,
): Modifier = this.pointerInput(Unit) {
    detectTapGestures(
        onTap = {
            onClick()
        },
        onLongPress = {
            onLongClick()
        }
    )
}