package com.example.notes.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.di.keys.ViewModelKey
import com.example.notes.di.scopes.AppScope
import com.example.notes.domain.usecase.GetNotesUseCase
import com.example.notes.domain.usecase.SortNotesListUseCase
import com.example.notes.presentation.mapper.NoteModelToNoteUiModelMapper
import com.example.notes.presentation.model.NoteUiModel
import com.example.notes.presentation.model.SortAction
import com.squareup.anvil.annotations.ContributesMultibinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
@ViewModelKey(HomeViewModel::class)
class HomeViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val noteModelUiMapper: NoteModelToNoteUiModelMapper,
    private val sortNotesList: SortNotesListUseCase,
) : ViewModel() {

    private val _notesFlow: MutableStateFlow<List<NoteUiModel>> = MutableStateFlow(listOf())
    val notesFlow: Flow<List<NoteUiModel>>
        get() = _notesFlow

    fun getNotes() {
        viewModelScope.launch {
            _notesFlow.value = getNotesUseCase().map(noteModelUiMapper::map)
        }
    }

    fun sortNotes(sortAction: SortAction) {
        _notesFlow.value.takeIf { notes ->
            notes.isNotEmpty()
        }?.let { notes ->
            _notesFlow.value = sortNotesList(notes, sortAction)
        }
    }
}