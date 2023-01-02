package com.example.notes.presentation.createnote

import androidx.lifecycle.ViewModel
import com.example.notes.di.keys.ViewModelKey
import com.example.notes.di.scopes.AppScope
import com.example.notes.domain.SaveNoteUseCase
import com.example.notes.presentation.model.CreateNoteUiModel
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
@ViewModelKey(CreateNoteViewModel::class)
class CreateNoteViewModel @Inject constructor(
    private val saveNoteUseCase: SaveNoteUseCase
): ViewModel() {

    fun saveNote(createNoteUiModel: CreateNoteUiModel): Boolean =
        saveNoteUseCase(createNoteUiModel)
}