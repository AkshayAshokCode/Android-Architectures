package com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.AddNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.DeleteNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.GetNotesUseCase
import kotlinx.coroutines.launch

class NoteViewModel(
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> get() = _notes

    init {
        fetchNotes()
    }

    private fun fetchNotes() {
        viewModelScope.launch {
            _notes.value = getNotesUseCase()
        }
    }

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            val newNote = Note(
                id = _notes.value?.size ?: 0,
                title = title,
                content = content
            )
            addNoteUseCase(newNote)
            fetchNotes()
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase(note)
            fetchNotes()
        }
    }
}