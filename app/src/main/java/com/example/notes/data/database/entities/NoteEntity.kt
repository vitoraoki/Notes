package com.example.notes.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val NOTES_TABLE = "notes_table"
const val COLUMN_TITLE = "title"
const val COLUMN_DESCRIPTION = "description"
const val COLUMN_CREATED_AT = "created_at"
const val COLUMN_PRIORITY = "priority"

@Entity(tableName = NOTES_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = COLUMN_TITLE) val title: String,
    @ColumnInfo(name = COLUMN_DESCRIPTION) val description: String,
    @ColumnInfo(name = COLUMN_CREATED_AT) val createdAt: Long,
    @ColumnInfo(name = COLUMN_PRIORITY) val priority: String,
) {
    companion object {
        const val DEFAULT_ID = 0L
    }
}
