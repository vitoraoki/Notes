package com.example.notes.domain.usecase

import com.example.notes.data.repository.NotesRepository
import com.example.notes.domain.model.NoteModel
import javax.inject.Inject

interface GetNotesUseCase {
    suspend operator fun invoke(): List<NoteModel>
}

class GetNotes @Inject constructor(
    private val notesRepository: NotesRepository
): GetNotesUseCase {

    override suspend fun invoke(): List<NoteModel> = notesRepository.getNotes()
}