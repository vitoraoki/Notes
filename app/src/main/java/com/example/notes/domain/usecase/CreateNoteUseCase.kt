package com.example.notes.domain.usecase

import com.example.notes.data.repository.NotesRepository
import com.example.notes.domain.mapper.CreateNoteUiModelToNoteModelMapper
import com.example.notes.presentation.model.CreateNoteUiModel
import javax.inject.Inject

interface CreateNoteUseCase {
    suspend operator fun invoke(createNoteUiModel: CreateNoteUiModel): Boolean
}

class CreateNote @Inject constructor(
    private val noteModelMapper: CreateNoteUiModelToNoteModelMapper,
    private val repository: NotesRepository,
): CreateNoteUseCase {

    override suspend fun invoke(createNoteUiModel: CreateNoteUiModel): Boolean {
        val noteModel = noteModelMapper.map(createNoteUiModel)
        return repository.createNote(noteModel)
    }
}