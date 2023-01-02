package com.example.notes.presentation.home.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.notes.presentation.home.listener.HomeClickListener
import com.example.notes.presentation.model.NotePriorityUi
import com.example.notes.presentation.model.NoteUiModel
import com.example.notes.ui.theme.NotesTheme
import java.util.*

@Composable
fun NotesScreen(
    notes: List<NoteUiModel>,
    listener: HomeClickListener,
) {
    ScreenLayout(listener = listener) {
        NotesList(notes = notes, listener = listener)
    }
}

@Composable
private fun ScreenLayout(
    listener: HomeClickListener,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = { FloatingActionButton(listener) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            content()
        }
    }
}

@Composable
private fun FloatingActionButton(listener: HomeClickListener) {
    FloatingActionButton(
        onClick = listener::onAddClick,
        backgroundColor = Color.Blue,
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = "",
            tint = Color.White,
        )
    }
}

@Composable
private fun NotesList(
    notes: List<NoteUiModel>,
    listener: HomeClickListener,
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

@Preview(showBackground = true)
@Composable
fun NotesScreenPreview() {
    NotesTheme(darkTheme = false) {
        NotesScreen(
            notes = listOf(
                NoteUiModel(
                    title = "Note title",
                    description = "Note description",
                    date = Date(System.currentTimeMillis()),
                    priority = NotePriorityUi.Critical
                )
            ),
            listener = object : HomeClickListener {
                override fun onClick(text: String) {}
                override fun onLongClick(text: String) {}
                override fun onAddClick() {}
            }
        )
    }
}