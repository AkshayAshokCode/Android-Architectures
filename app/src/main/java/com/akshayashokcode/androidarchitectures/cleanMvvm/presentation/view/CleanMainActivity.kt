package com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshayashokcode.androidarchitectures.R
import com.akshayashokcode.androidarchitectures.cleanMvvm.data.repository.NoteRepository
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.AddNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.DeleteNoteUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.usecase.GetNotesUseCase
import com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.viewmodel.NoteViewModel
import com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.viewmodel.NoteViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CleanMainActivity: AppCompatActivity() {
    private lateinit var architectureTitleTextView: TextView

    private val viewModel: NoteViewModel by viewModels() {
        NoteViewModelFactory(
            GetNotesUseCase(NoteRepository()),
            AddNoteUseCase(NoteRepository()),
            DeleteNoteUseCase(NoteRepository())
        )
    }
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        architectureTitleTextView = findViewById(R.id.architectureTitle)
        architectureTitleTextView.text = "MVVM Architecture"
        val recyclerView = findViewById<RecyclerView>(R.id.noteList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = NoteAdapter(listOf()) // Initially empty list
        recyclerView.adapter = adapter

        viewModel.notes.observe(this, { notes ->
            adapter.updateNotes(notes)
        })

        findViewById<FloatingActionButton>(R.id.addNoteButton).setOnClickListener {
            viewModel.addNote("New Note", "Content")
        }
    }
}