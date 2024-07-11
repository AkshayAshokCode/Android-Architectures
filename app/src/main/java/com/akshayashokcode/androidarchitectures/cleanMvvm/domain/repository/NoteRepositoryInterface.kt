package com.akshayashokcode.androidarchitectures.cleanMvvm.domain.repository

import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note

interface NoteRepositoryInterface {
    suspend fun getNotes(): List<Note>
    suspend fun addNote(note: Note)
    suspend fun deleteNote(note: Note)
}