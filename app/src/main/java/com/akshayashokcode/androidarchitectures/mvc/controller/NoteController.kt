package com.akshayashokcode.androidarchitectures.mvc.controller

import com.akshayashokcode.androidarchitectures.mvc.model.Note
import com.akshayashokcode.androidarchitectures.mvc.model.NoteRepository

class NoteController(private val repository: NoteRepository) {

    fun getNotes(): List<Note> {
        return repository.getNotes()
    }

    fun addNote(note: Note) {
        repository.addNote(note)
    }

    fun deleteNote(note: Note) {
        repository.deleteNote(note)
    }
}