package com.example.notes.data.mapper

import com.example.notes.data.database.entities.NoteEntity
import com.example.notes.domain.model.NoteModel
import com.example.notes.utils.Mapper
import javax.inject.Inject

class NoteModelToNoteEntityMapper @Inject constructor() : Mapper<NoteModel, NoteEntity> {

    override fun map(it: NoteModel) =
        NoteEntity(
            id = getIdOrDefaultId(it.id),
            title = it.title,
            description = it.description,
            createdAt = it.createdAt.time,
            priority = it.priority.name,
        )

    private fun getIdOrDefaultId(id: String) = if (id.isNotEmpty()) {
        id.toLong()
    } else {
        NoteEntity.DEFAULT_ID
    }
}