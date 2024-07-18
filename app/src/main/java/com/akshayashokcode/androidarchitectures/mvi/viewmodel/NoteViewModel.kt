package com.akshayashokcode.androidarchitectures.mvi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akshayashokcode.androidarchitectures.mvi.model.Note
import com.akshayashokcode.androidarchitectures.mvi.model.NoteIntent
import com.akshayashokcode.androidarchitectures.mvi.model.NoteState

class NoteViewModel : ViewModel() {

    private val _state = MutableLiveData<NoteState>()
    val state: LiveData<NoteState> = _state

    private val notes = mutableListOf<Note>()

    init {
        // Initialize ViewModel with an empty state
        _state.value = NoteState.Notes(emptyList())
    }

    fun processIntent(intent: NoteIntent) {
        when (intent) {
            is NoteIntent.LoadNotes -> loadNotes()
            is NoteIntent.AddNote -> addNote(intent.title, intent.content)
            is NoteIntent.DeleteNote -> deleteNote(intent.note)
        }
    }

    private fun loadNotes() {
        // In a real app, this would load notes from a repository or database
        // For simplicity, we'll use the local list of notes
        _state.value = NoteState.Notes(notes)
    }

    private fun addNote(title: String, content: String) {
        val newNote = Note(
            id = notes.size + 1, // Generate ID based on current list size (simple example)
            title = title,
            content = content
        )
        notes.add(newNote)
        _state.value = NoteState.Notes(notes.toList()) // Emit updated list of notes
    }

    private fun deleteNote(note: Note) {
        // Handle logic to delete a note
        // This is where you would interact with a repository or data source
        // For simplicity, we won't implement it here
    }
}