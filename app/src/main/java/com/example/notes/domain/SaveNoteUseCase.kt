package com.example.notes.domain

import com.example.notes.data.repository.NotesRepository
import com.example.notes.di.scopes.AppScope
import com.example.notes.domain.mapper.CreateNoteUiModelToNoteModelMapper
import com.example.notes.presentation.model.CreateNoteUiModel
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

interface SaveNoteUseCase {
    operator fun invoke(createNoteUiModel: CreateNoteUiModel): Boolean
}

@ContributesBinding(AppScope::class)
class SaveNote @Inject constructor(
    private val noteModelMapper: CreateNoteUiModelToNoteModelMapper,
    private val repository: NotesRepository,
): SaveNoteUseCase {

    override fun invoke(createNoteUiModel: CreateNoteUiModel): Boolean {
        val noteModel = noteModelMapper.map(createNoteUiModel)
        return repository.saveNote(noteModel)
    }
}