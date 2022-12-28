package com.example.notes.data.repository

import com.example.notes.data.database.NotesDataBase
import com.example.notes.data.mapper.NoteDataToNoteModelMapper
import com.example.notes.domain.model.NoteModel
import javax.inject.Inject
import javax.inject.Singleton

interface NotesRepository {
    fun mockNotesList(): List<NoteModel>
}

@Singleton
class NotesRepositoryImpl @Inject constructor(
    private val notesDataBase: NotesDataBase,
    private val noteModelMapper: NoteDataToNoteModelMapper,
): NotesRepository {

    override fun mockNotesList(): List<NoteModel> =
        notesDataBase.mockNotesList().map(noteModelMapper::map)
}