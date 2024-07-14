package com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase

import androidx.lifecycle.LiveData
import com.akshayashokcode.androidarchitectures.cleanMvvm.data.repository.NoteRepository
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note

class GetNotesUseCase(private val noteRepository: NoteRepository) {

    operator fun invoke(): LiveData<List<Note>> {
        return noteRepository.getAllNotes()
    }
}