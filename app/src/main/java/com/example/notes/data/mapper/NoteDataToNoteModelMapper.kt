package com.example.notes.data.mapper

import com.example.notes.data.model.NoteData
import com.example.notes.domain.model.NoteModel
import java.util.*
import javax.inject.Inject

class NoteDataToNoteModelMapper @Inject constructor(
    private val notePriorityMapper: NotePriorityDataToNotePriorityMapper
) {

    fun map(noteData: NoteData): NoteModel =
        NoteModel(
            id = noteData.id,
            title = noteData.title,
            description = noteData.description,
            date = Date(noteData.date),
            priority = notePriorityMapper.map(noteData.priority)
        )
}