package com.example.notes.domain.mapper

import com.example.notes.domain.model.NoteModel
import com.example.notes.presentation.model.NoteUiModel
import com.example.notes.utils.Mapper
import javax.inject.Inject

class NoteUiModelToNoteModelMapper @Inject constructor(
    private val notePriorityMapper: NotePriorityUiToNotePriorityMapper,
) : Mapper<NoteUiModel, NoteModel> {

    override fun map(it: NoteUiModel) =
        NoteModel(
            id = it.id,
            title = it.title,
            description = it.description,
            createdAt = it.createdAt,
            priority = notePriorityMapper.map(it.priority)
        )
}