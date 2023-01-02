package com.example.notes.data.repository

import com.example.notes.data.database.NotesDataBase
import com.example.notes.data.mapper.NoteDataToNoteModelMapper
import com.example.notes.di.scopes.AppScope
import com.example.notes.domain.model.NoteModel
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import javax.inject.Singleton

interface NotesRepository {
    fun saveNote(noteModel: NoteModel): Boolean
    fun getNotes(): List<NoteModel>
}

@Singleton
@ContributesBinding(AppScope::class)
class NotesRepositoryImpl @Inject constructor(
    private val notesDataBase: NotesDataBase,
    private val noteModelMapper: NoteDataToNoteModelMapper,
) : NotesRepository {

    override fun saveNote(noteModel: NoteModel) =
        notesDataBase.saveNote(noteModel)

    override fun getNotes(): List<NoteModel> =
        notesDataBase.getNotes().map(noteModelMapper::map)
}