package com.akshayashokcode.androidarchitectures.mvvm.model

class NoteRepository {
    private val notes = mutableListOf<Note>()

    fun getNotes(): List<Note> {
        return notes
    }

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun deleteNote(note: Note) {
        notes.remove(note)
    }
}