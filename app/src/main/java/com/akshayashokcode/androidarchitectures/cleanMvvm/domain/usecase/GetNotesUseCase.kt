package com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase

import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.repository.NoteRepositoryInterface

class GetNotesUseCase(private val noteRepository: NoteRepositoryInterface) {

    suspend operator fun invoke(): List<Note> {
        return noteRepository.getNotes()
    }
}