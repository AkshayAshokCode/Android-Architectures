package com.akshayashokcode.androidarchitectures.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akshayashokcode.androidarchitectures.mvvm.model.Note
import com.akshayashokcode.androidarchitectures.mvvm.model.NoteRepository

class NoteViewModel : ViewModel() {

    private val repository = NoteRepository()
    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    init {
        loadNotes()
    }

    private fun loadNotes() {
        _notes.value = repository.getNotes()
    }

    fun addNote(note: Note) {
        repository.addNote(note)
        loadNotes()
    }

    fun deleteNote(note: Note) {
        repository.deleteNote(note)
        loadNotes()
    }
}
