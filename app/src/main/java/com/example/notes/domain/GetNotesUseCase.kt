package com.example.notes.domain

import com.example.notes.data.repository.NotesRepository
import com.example.notes.domain.model.NoteModel
import javax.inject.Inject

interface GetNotesUseCase {
    operator fun invoke(): List<NoteModel>
}

class GetNotes @Inject constructor(
    private val notesRepository: NotesRepository
): GetNotesUseCase {

    override operator fun invoke(): List<NoteModel> = notesRepository.mockNotesList()
}