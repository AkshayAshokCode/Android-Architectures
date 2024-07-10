package com.akshayashokcode.androidarchitectures.mvp.view

import com.akshayashokcode.androidarchitectures.mvp.model.Note

interface NoteView {
    fun displayNotes(notes: List<Note>)
    fun displayNoteAdded(note: Note)
    fun displayNoteDeleted(note: Note)
}