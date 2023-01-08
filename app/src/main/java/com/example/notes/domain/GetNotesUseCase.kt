package com.example.notes.domain

import com.example.notes.data.repository.NotesRepository
import com.example.notes.di.scopes.AppScope
import com.example.notes.domain.model.NoteModel
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

interface GetNotesUseCase {
    suspend operator fun invoke(): List<NoteModel>
}

@ContributesBinding(AppScope::class)
class GetNotes @Inject constructor(
    private val notesRepository: NotesRepository
): GetNotesUseCase {

    override suspend fun invoke(): List<NoteModel> = notesRepository.getNotes()
}