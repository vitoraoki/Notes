package com.example.notes.presentation.createnote.listener

import com.example.notes.presentation.model.CreateNoteUiModel

interface OnCreateNoteListener {
    fun onCreateClick(createNoteUiModel: CreateNoteUiModel)
}