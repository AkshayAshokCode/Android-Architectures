package com.akshayashokcode.androidarchitectures.cleanMvvm.data.repository

import com.akshayashokcode.androidarchitectures.cleanMvvm.data.local.NoteDao
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun getNotes(): List<Note> {
        return noteDao.getNotes()
    }

    suspend fun addNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }
}