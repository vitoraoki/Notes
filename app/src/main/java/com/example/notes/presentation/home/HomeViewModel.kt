package com.example.notes.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.usecase.DeleteNoteUseCase
import com.example.notes.domain.usecase.GetNotesUseCase
import com.example.notes.domain.usecase.SortNotesListUseCase
import com.example.notes.presentation.mapper.NoteModelToNoteUiModelMapper
import com.example.notes.presentation.model.NoteUiModel
import com.example.notes.presentation.model.SortAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val noteUiModelMapper: NoteModelToNoteUiModelMapper,
    private val sortNotesList: SortNotesListUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
) : ViewModel() {

    private val _notesFlow: MutableStateFlow<List<NoteUiModel>> = MutableStateFlow(listOf())
    val notesFlow: Flow<List<NoteUiModel>>
        get() = _notesFlow

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            _notesFlow.value = getNotesUseCase().map(noteUiModelMapper::map)
        }
    }

    fun sortNotes(sortAction: SortAction) {
        _notesFlow.value.takeIf { notes ->
            notes.isNotEmpty()
        }?.let { notes ->
            _notesFlow.value = sortNotesList(notes, sortAction)
        }
    }

    fun deleteNote(noteUiModel: NoteUiModel) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNoteUseCase(noteUiModel)
            _notesFlow.value = getNotesUseCase().map(noteUiModelMapper::map)
        }
    }
}