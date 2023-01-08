package com.example.notes.presentation.createnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.di.keys.ViewModelKey
import com.example.notes.di.scopes.AppScope
import com.example.notes.domain.usecase.CreateNoteUseCase
import com.example.notes.presentation.model.CreateNoteUiModel
import com.squareup.anvil.annotations.ContributesMultibinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
@ViewModelKey(CreateNoteViewModel::class)
class CreateNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase
): ViewModel() {

    private val _saveNoteResult: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val saveNoteResult: Flow<Boolean>
        get() = _saveNoteResult.filterNotNull()

    fun createNote(createNoteUiModel: CreateNoteUiModel) {
        viewModelScope.launch {
            _saveNoteResult.value = createNoteUseCase(createNoteUiModel)
        }
    }
}