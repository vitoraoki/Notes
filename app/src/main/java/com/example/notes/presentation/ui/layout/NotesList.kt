package com.example.notes.presentation.ui.layout

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.notes.NoteClickListener
import com.example.notes.presentation.ui.model.NoteUiModel

@Composable
fun NotesList(
    notes: List<NoteUiModel>,
    listener: NoteClickListener,
) {
    LazyColumn {
        items(items = notes) { note ->
            NoteLayout(
                uiModel = note,
                clickListener = listener
            )
        }
    }
}