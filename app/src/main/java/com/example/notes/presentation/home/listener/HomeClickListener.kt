package com.example.notes.presentation.home.listener

interface HomeClickListener: NoteClickListener {
    fun onAddClick()
}

interface NoteClickListener {
    fun onClick(text: String)
    fun onLongClick(text: String)
}