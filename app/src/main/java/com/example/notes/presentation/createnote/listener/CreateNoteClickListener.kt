package com.example.notes.presentation.createnote.listener

import com.example.notes.presentation.model.CreateNoteUiModel

interface CreateNoteClickListener {
    fun onCreateClick(createNoteUiModel: CreateNoteUiModel)
    fun onCloseClick()
}