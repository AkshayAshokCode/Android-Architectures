package com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshayashokcode.androidarchitectures.R
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note
import com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.viewmodel.NoteViewModel
import com.akshayashokcode.androidarchitectures.cleanMvvm.presentation.viewmodel.NoteViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CleanMainActivity: AppCompatActivity() {
    private lateinit var architectureTitleTextView: TextView

    private val viewModel: NoteViewModel by viewModels { NoteViewModelFactory(application) }

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

        viewModel.notes.observe(this) { notes ->
            adapter.updateNotes(notes)
        }

        findViewById<FloatingActionButton>(R.id.addNoteButton).setOnClickListener {
            val newNote = Note(
                id = 0,
                title = "New Note",
                content = "Content"
            )
            viewModel.addNote(newNote)
        }
    }
}