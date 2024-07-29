package com.example.notes.presentation.createnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.usecase.CreateNoteUseCase
import com.example.notes.presentation.model.CreateNoteUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase
): ViewModel() {

    private val _saveNoteResult: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val saveNoteResult: Flow<Boolean>
        get() = _saveNoteResult.filterNotNull()

    fun createNote(createNoteUiModel: CreateNoteUiModel) {
        viewModelScope.launch(Dispatchers.IO) {
            _saveNoteResult.value = createNoteUseCase(createNoteUiModel)
        }
    }
}