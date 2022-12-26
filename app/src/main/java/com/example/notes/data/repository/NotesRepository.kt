package com.example.notes.data.repository

import com.example.notes.data.database.NotesDataBase
import com.example.notes.data.mapper.NoteDataToNoteModelMapper
import com.example.notes.domain.model.NoteModel

class NotesRepository {

    private val notesDataBase = NotesDataBase()
    private val noteModelMapper = NoteDataToNoteModelMapper()

    fun mockNotesList(): List<NoteModel> =
        notesDataBase.mockNotesList().map(noteModelMapper::map)
}