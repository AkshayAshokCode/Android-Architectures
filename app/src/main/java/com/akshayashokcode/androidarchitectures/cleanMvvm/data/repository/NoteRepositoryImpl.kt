package com.akshayashokcode.androidarchitectures.cleanMvvm.data.repository

import androidx.lifecycle.LiveData
import com.akshayashokcode.androidarchitectures.cleanMvvm.data.local.NoteDao
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun getAllNotes(): LiveData<List<Note>> {
        return noteDao.getAllNotes()
    }

    override suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    override suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}