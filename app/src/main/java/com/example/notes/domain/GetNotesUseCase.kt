package com.example.notes.domain

import com.example.notes.data.repository.NotesRepository
import com.example.notes.domain.model.NoteModel

class GetNotesUseCase {

    private val notesRepository = NotesRepository()

    operator fun invoke(): List<NoteModel> = notesRepository.mockNotesList()
}