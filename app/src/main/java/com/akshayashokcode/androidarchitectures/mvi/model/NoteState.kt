package com.akshayashokcode.androidarchitectures.mvi.model

sealed class NoteState {
    object Loading : NoteState()
    data class Notes(val notes: List<Note>) : NoteState()
    data class Error(val error: String) : NoteState()
}