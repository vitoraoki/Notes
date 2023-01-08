package com.example.notes.data.repository

import com.example.notes.data.database.dao.NotesDao
import com.example.notes.data.mapper.NoteEntityToNoteModelMapper
import com.example.notes.data.mapper.NoteModelToNoteEntityMapper
import com.example.notes.di.scopes.AppScope
import com.example.notes.domain.model.NoteModel
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import javax.inject.Singleton

interface NotesRepository {
    suspend fun createNote(noteModel: NoteModel): Boolean
    suspend fun getNotes(): List<NoteModel>
}

@Singleton
@ContributesBinding(AppScope::class)
class NotesRepositoryImpl @Inject constructor(
    private val notesDao: NotesDao,
    private val noteEntityMapper: NoteModelToNoteEntityMapper,
    private val noteModelMapper: NoteEntityToNoteModelMapper,
) : NotesRepository {

    override suspend fun createNote(noteModel: NoteModel): Boolean = try {
        val noteEntity = noteEntityMapper.map(noteModel)
        notesDao.createNote(noteEntity)
        true
    } catch (e: Exception) {
        false
    }

    override suspend fun getNotes(): List<NoteModel> = try {
        notesDao.getAllNotesOrderedByCreatedAt().map(noteModelMapper::map)
    } catch (e: Exception) {
        listOf()
    }
}