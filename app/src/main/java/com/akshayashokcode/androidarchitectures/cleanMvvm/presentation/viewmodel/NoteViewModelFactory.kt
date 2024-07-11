package com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.AddNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.DeleteNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.GetNotesUseCase

class NoteViewModelFactory(
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(getNotesUseCase, addNoteUseCase, deleteNoteUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}