package com.example.notes.domain.usecase

import com.example.notes.presentation.model.NoteUiModel
import com.example.notes.presentation.model.SortAction
import javax.inject.Inject

interface SortNotesListUseCase {
    operator fun invoke(
        notes: List<NoteUiModel>,
        sortAction: SortAction
    ): List<NoteUiModel>
}

class SortNotesList @Inject constructor() : SortNotesListUseCase {

    override fun invoke(
        notes: List<NoteUiModel>,
        sortAction: SortAction
    ): List<NoteUiModel> =
        when(sortAction) {
            SortAction.SORT_BY_CREATED_AT_ASC -> sortByCreatedAtAscending(notes)
            SortAction.SORT_BY_CREATED_AT_DESC -> sortByCreatedAtDescending(notes)
            SortAction.SORT_BY_TITLE_ASC -> sortByTitleAscending(notes)
            SortAction.SORT_BY_TITLE_DESC -> sortByTitleDescending(notes)
        }

    private fun sortByCreatedAtAscending(notes: List<NoteUiModel>) =
        notes.sortedBy { it.createdAt }

    private fun sortByCreatedAtDescending(notes: List<NoteUiModel>) =
        notes.sortedByDescending { it.createdAt }

    private fun sortByTitleAscending(notes: List<NoteUiModel>) =
        notes.sortedBy { it.title }

    private fun sortByTitleDescending(notes: List<NoteUiModel>) =
        notes.sortedByDescending { it.title }
}