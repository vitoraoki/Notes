package com.example.notes.data.mapper

import com.example.notes.data.model.NoteData
import com.example.notes.domain.model.NoteModel
import com.example.notes.utils.Mapper
import java.util.*
import javax.inject.Inject

class NoteDataToNoteModelMapper @Inject constructor(
    private val notePriorityMapper: NotePriorityDataToNotePriorityMapper
): Mapper<NoteData, NoteModel> {

    override fun map(it: NoteData): NoteModel =
        NoteModel(
            id = it.id,
            title = it.title,
            description = it.description,
            date = Date(it.date),
            priority = notePriorityMapper.map(it.priority)
        )
}