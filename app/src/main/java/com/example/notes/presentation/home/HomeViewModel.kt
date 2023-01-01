package com.example.notes.presentation.home

import androidx.lifecycle.ViewModel
import com.example.notes.di.keys.ViewModelKey
import com.example.notes.di.scopes.AppScope
import com.example.notes.domain.GetNotesUseCase
import com.example.notes.presentation.mapper.NoteModelToNoteUiModelMapper
import com.example.notes.presentation.ui.model.NoteUiModel
import com.squareup.anvil.annotations.ContributesMultibinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
@ViewModelKey(HomeViewModel::class)
class HomeViewModel @Inject constructor(
    getNotes: GetNotesUseCase,
    private val noteModelUiMapper: NoteModelToNoteUiModelMapper,
) : ViewModel() {

    private val _notesFlow: MutableStateFlow<List<NoteUiModel>> = MutableStateFlow(listOf())
    val notesFlow: Flow<List<NoteUiModel>>
        get() = _notesFlow

    init {
        _notesFlow.value = getNotes().map(noteModelUiMapper::map)
    }
}