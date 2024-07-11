package com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase

import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.repository.NoteRepositoryInterface

class AddNoteUseCase(private val noteRepository: NoteRepositoryInterface) {

    suspend operator fun invoke(note: Note) {
        noteRepository.addNote(note)
    }
}