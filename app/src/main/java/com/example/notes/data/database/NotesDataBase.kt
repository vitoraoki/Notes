package com.example.notes.data.database

import com.example.notes.data.model.CRITICAL
import com.example.notes.data.model.LOW
import com.example.notes.data.model.MEDIUM
import com.example.notes.data.model.NoteData

class NotesDataBase {

    fun mockNotesList(): List<NoteData> =
        listOf(
            NoteData(
                id = "1",
                title = "Critical Note 1",
                description = "Critical Note 1 description",
                date = System.currentTimeMillis(),
                priority = CRITICAL
            ),
            NoteData(
                id = "2",
                title = "Medium Note 1",
                description = "Medium Note 1 description",
                date = System.currentTimeMillis(),
                priority = MEDIUM
            ),
            NoteData(
                id = "3",
                title = "Low Note 1",
                description = "Low Note 1 description",
                date = System.currentTimeMillis(),
                priority = LOW
            ),
            NoteData(
                id = "4",
                title = "Critical Note 2",
                description = "Critical Note 2 description",
                date = System.currentTimeMillis(),
                priority = CRITICAL
            ),
            NoteData(
                id = "5",
                title = "Medium Note 2",
                description = "Medium Note 2 description",
                date = System.currentTimeMillis(),
                priority = MEDIUM
            ),
            NoteData(
                id = "6",
                title = "Low Note 2",
                description = "Low Note 2 description",
                date = System.currentTimeMillis(),
                priority = LOW
            ),
            NoteData(
                id = "7",
                title = "Critical Note 3",
                description = "Critical Note 3 description",
                date = System.currentTimeMillis(),
                priority = CRITICAL
            ),
            NoteData(
                id = "8",
                title = "Medium Note 3",
                description = "Medium Note 3 description",
                date = System.currentTimeMillis(),
                priority = MEDIUM
            ),
            NoteData(
                id = "9",
                title = "Low Note 3",
                description = "Low Note 3 description",
                date = System.currentTimeMillis(),
                priority = LOW
            ),
            NoteData(
                id = "10",
                title = "Critical Note 4",
                description = "Critical Note 4 description",
                date = System.currentTimeMillis(),
                priority = CRITICAL
            ),
            NoteData(
                id = "11",
                title = "Medium Note 4",
                description = "Medium Note 4 description",
                date = System.currentTimeMillis(),
                priority = MEDIUM
            ),
            NoteData(
                id = "12",
                title = "Low Note 4",
                description = "Low Note 4 description",
                date = System.currentTimeMillis(),
                priority = LOW
            ),
            NoteData(
                id = "13",
                title = "Critical Note 5",
                description = "Critical Note 5 description",
                date = System.currentTimeMillis(),
                priority = CRITICAL
            ),
            NoteData(
                id = "14",
                title = "Medium Note 5",
                description = "Medium Note 5 description",
                date = System.currentTimeMillis(),
                priority = MEDIUM
            ),
            NoteData(
                id = "15",
                title = "Low Note 5",
                description = "Low Note 5 description",
                date = System.currentTimeMillis(),
                priority = LOW
            ),
            NoteData(
                id = "16",
                title = "Critical Note 6",
                description = "Critical Note 6 description",
                date = System.currentTimeMillis(),
                priority = CRITICAL
            ),
            NoteData(
                id = "17",
                title = "Medium Note 6",
                description = "Medium Note 6 description",
                date = System.currentTimeMillis(),
                priority = MEDIUM
            ),
            NoteData(
                id = "18",
                title = "Low Note 6",
                description = "Low Note 6 description",
                date = System.currentTimeMillis(),
                priority = LOW
            ),
            NoteData(
                id = "19",
                title = "Critical Note 7",
                description = "Critical Note 7 description",
                date = System.currentTimeMillis(),
                priority = CRITICAL
            ),
            NoteData(
                id = "20",
                title = "Medium Note 7",
                description = "Medium Note 7 description",
                date = System.currentTimeMillis(),
                priority = MEDIUM
            ),
            NoteData(
                id = "21",
                title = "Low Note 7",
                description = "Low Note 7 description",
                date = System.currentTimeMillis(),
                priority = LOW
            ),
            NoteData(
                id = "22",
                title = "Critical Note 8",
                description = "Critical Note 8 description",
                date = System.currentTimeMillis(),
                priority = CRITICAL
            ),
            NoteData(
                id = "23",
                title = "Medium Note 8",
                description = "Medium Note 8 description",
                date = System.currentTimeMillis(),
                priority = MEDIUM
            ),
            NoteData(
                id = "24",
                title = "Low Note 8",
                description = "Low Note 8 description",
                date = System.currentTimeMillis(),
                priority = LOW
            )
        )
}