package com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshayashokcode.androidarchitectures.cleanMvvm.data.local.NoteDatabase
import com.akshayashokcode.androidarchitectures.cleanMvvm.data.repository.NoteRepositoryImpl
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.AddNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.DeleteNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.GetNotesUseCase
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val addNoteUseCase: AddNoteUseCase
    private val deleteNoteUseCase: DeleteNoteUseCase
    private val getNotesUseCase: GetNotesUseCase

    val notes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        val repository = NoteRepositoryImpl(noteDao)
        addNoteUseCase = AddNoteUseCase(repository)
        deleteNoteUseCase = DeleteNoteUseCase(repository)
        getNotesUseCase = GetNotesUseCase(repository)

        notes = getNotesUseCase()
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase(note)
        }
    }
}