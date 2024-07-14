package com.akshayashokcode.androidarchitectures.cleanMvvm.data.repository

import androidx.lifecycle.LiveData
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note

interface NoteRepository {
    fun getAllNotes(): LiveData<List<Note>>
    suspend fun insert(note: Note)
    suspend fun delete(note: Note)
}