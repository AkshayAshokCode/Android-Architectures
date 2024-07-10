package com.akshayashokcode.androidarchitectures.mvp.presenter

import com.akshayashokcode.androidarchitectures.mvp.model.Note
import com.akshayashokcode.androidarchitectures.mvp.model.NoteRepository
import com.akshayashokcode.androidarchitectures.mvp.view.NoteView

class NotePresenter(private val view: NoteView, private val repository: NoteRepository) {

    fun loadNotes() {
        view.displayNotes(repository.getNotes())
    }

    fun getNotes(): List<Note> {
        return repository.getNotes()
    }

    fun addNote(note: Note) {
        repository.addNote(note)
        view.displayNoteAdded(note)
    }

    fun deleteNote(note: Note) {
        repository.deleteNote(note)
        view.displayNoteDeleted(note)
    }
}