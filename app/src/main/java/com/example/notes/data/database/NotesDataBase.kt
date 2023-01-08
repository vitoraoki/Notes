package com.example.notes.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.data.database.dao.NotesDao
import com.example.notes.data.database.entities.NoteEntity

const val DATABASE_NAME = "notes_database"
const val DATABASE_VERSION = 1

@Database(entities = [NoteEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}