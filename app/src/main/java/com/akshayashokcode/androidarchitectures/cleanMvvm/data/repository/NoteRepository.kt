package com.akshayashokcode.androidarchitectures.cleanMvvm.data.repository

import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.repository.NoteRepositoryInterface

class NoteRepository : NoteRepositoryInterface {

    private val notes = mutableListOf<Note>()

    override suspend fun getNotes(): List<Note> {
        return notes
    }

    override suspend fun addNote(note: Note) {
        notes.add(note.copy(id = notes.size)) // Assign incremental IDs
    }

    override suspend fun deleteNote(note: Note) {
        notes.remove(note)
    }
}