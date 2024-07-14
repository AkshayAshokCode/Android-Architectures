package com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase

import com.akshayashokcode.androidarchitectures.cleanMvvm.data.repository.NoteRepository
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note

class GetNotesUseCase(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(): List<Note> {
        return noteRepository.getNotes()
    }
}