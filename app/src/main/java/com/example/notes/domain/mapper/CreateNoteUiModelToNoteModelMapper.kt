package com.example.notes.domain.mapper

import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.model.CreateNoteUiModel
import com.example.notes.utils.Mapper
import javax.inject.Inject

class CreateNoteUiModelToNoteModelMapper @Inject constructor() :
    Mapper<CreateNoteUiModel, NoteModel> {

    override fun map(it: CreateNoteUiModel): NoteModel =
        NoteModel(
            title = it.title,
            description = it.description,
            createdAt = it.createdAt,
            priority = NotePriority.fromString(it.priority)
        )
}