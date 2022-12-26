package com.example.notes.presentation

import androidx.lifecycle.ViewModel
import com.example.notes.domain.GetNotesUseCase
import com.example.notes.presentation.mapper.NoteModelToNoteUiModelMapper
import com.example.notes.presentation.ui.model.NoteUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    private val getNotes = GetNotesUseCase()
    private val noteModelUiMapper = NoteModelToNoteUiModelMapper()

    private val _notesFlow: MutableStateFlow<List<NoteUiModel>> = MutableStateFlow(listOf())
    val notesFlow: Flow<List<NoteUiModel>>
        get() = _notesFlow

    init {
        _notesFlow.value = getNotes().map(noteModelUiMapper::map)
    }
}