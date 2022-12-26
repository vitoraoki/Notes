package com.example.notes

interface NoteClickListener {
    fun onClick(text: String)
    fun onLongClick(text: String)
}