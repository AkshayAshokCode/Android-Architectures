package com.akshayashokcode.androidarchitectures.mvi.model

sealed class NoteIntent {
    object LoadNotes : NoteIntent()
    data class AddNote(val title: String, val content: String) : NoteIntent()
    data class DeleteNote(val note: Note) : NoteIntent()
}