package com.example.notes.domain.usecase

import com.example.notes.data.repository.NotesRepository
import com.example.notes.di.scopes.AppScope
import com.example.notes.domain.mapper.NoteUiModelToNoteModelMapper
import com.example.notes.presentation.model.NoteUiModel
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

interface DeleteNoteUseCase {
    suspend operator fun invoke(noteUiModel: NoteUiModel): Boolean
}

@ContributesBinding(AppScope::class)
class DeleteNote @Inject constructor(
    private val noteModelMapper: NoteUiModelToNoteModelMapper,
    private val repository: NotesRepository,
) : DeleteNoteUseCase {

    override suspend fun invoke(noteUiModel: NoteUiModel): Boolean {
        val noteModel = noteModelMapper.map(noteUiModel)
        return repository.deleteNote(noteModel)
    }
}