package com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.AddNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.DeleteNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.GetNotesUseCase

class NoteViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}