package com.example.notes.data.mapper

import com.example.notes.data.model.NoteData
import com.example.notes.domain.model.NoteModel
import javax.inject.Inject

class NoteModelToNoteDataMapper @Inject constructor(
    private val notePriorityDataMapper: NotePriorityToNotePriorityDataMapper
) {

    fun map(
        id: String,
        noteModel: NoteModel,
    ): NoteData =
        NoteData(
            id = id,
            title = noteModel.title,
            description = noteModel.description,
            date = noteModel.date.time,
            priority = notePriorityDataMapper.map(noteModel.priority)
        )
}