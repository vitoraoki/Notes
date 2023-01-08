package com.example.notes.presentation.home.listener

import com.example.notes.presentation.model.SortAction

interface HomeClickListener: NoteClickListener {
    fun onAddClick()
    fun onSortClick(sortAction: SortAction)
}

interface NoteClickListener {
    fun onClick(text: String)
    fun onLongClick(text: String)
}