package com.example.notes.data.database.dao

import androidx.room.*
import com.example.notes.data.database.entities.COLUMN_CREATED_AT
import com.example.notes.data.database.entities.NOTES_TABLE
import com.example.notes.data.database.entities.NoteEntity

const val GET_ALL_NOTES = "SELECT * FROM $NOTES_TABLE ORDER BY $COLUMN_CREATED_AT ASC"

@Dao
interface NotesDao {

    @Query(GET_ALL_NOTES)
    fun getAllNotesOrderedByCreatedAt(): List<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)
}