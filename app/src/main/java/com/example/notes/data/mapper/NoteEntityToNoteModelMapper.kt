package com.example.notes.data.mapper

import com.example.notes.data.database.entities.NoteEntity
import com.example.notes.domain.model.NoteModel
import com.example.notes.domain.model.NotePriority
import com.example.notes.utils.Mapper
import java.util.*
import javax.inject.Inject

class NoteEntityToNoteModelMapper @Inject constructor(): Mapper<NoteEntity, NoteModel> {

    override fun map(it: NoteEntity): NoteModel =
        NoteModel(
            id = it.id.toString(),
            title = it.title,
            description = it.description,
            createdAt = Date(it.createdAt),
            priority = NotePriority.fromString(it.priority),
        )
}