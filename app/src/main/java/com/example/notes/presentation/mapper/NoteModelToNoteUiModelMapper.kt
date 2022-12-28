package com.example.notes.presentation.mapper

import com.example.notes.domain.model.NoteModel
import com.example.notes.presentation.ui.model.NoteUiModel
import javax.inject.Inject

class NoteModelToNoteUiModelMapper @Inject constructor(
    private val notePriorityUiMapper: NotePriorityToNotePriorityUiMapper
) {

    fun map(noteModel: NoteModel): NoteUiModel =
        NoteUiModel(
            title = noteModel.title,
            description = noteModel.description,
            date = noteModel.date,
            priority = notePriorityUiMapper.map(noteModel.priority)
        )
}