package com.example.notes.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.notes.NoteClickListener
import com.example.notes.presentation.ui.layout.NotesList
import com.example.notes.ui.theme.NotesTheme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : ComponentActivity(), NoteClickListener {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.notesFlow.onEach { notes ->
            setContent {
                NotesTheme {
                    NotesList(
                        notes = notes,
                        listener = this@MainActivity
                    )
                }
            }
        }.launchIn(lifecycleScope)
    }

    override fun onClick(text: String) {
        Toast.makeText(this, "Click - $text", Toast.LENGTH_SHORT).show()
    }

    override fun onLongClick(text: String) {
        Toast.makeText(this, "Long Click - $text", Toast.LENGTH_SHORT).show()
    }
}