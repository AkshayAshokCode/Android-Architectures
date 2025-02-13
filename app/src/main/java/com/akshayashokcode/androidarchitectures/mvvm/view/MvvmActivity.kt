package com.akshayashokcode.androidarchitectures.mvvm.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshayashokcode.androidarchitectures.R
import com.akshayashokcode.androidarchitectures.mvvm.model.Note
import com.akshayashokcode.androidarchitectures.mvvm.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MvvmActivity : AppCompatActivity() {

    private lateinit var viewModel: NoteViewModel
    private lateinit var adapter: NoteAdapter
    private lateinit var architectureTitleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        architectureTitleTextView = findViewById(R.id.architectureTitle)
        architectureTitleTextView.text = "MVVM Architecture"
        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        val recyclerView = findViewById<RecyclerView>(R.id.noteList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = NoteAdapter(listOf()) // Initially empty list
        recyclerView.adapter = adapter

        viewModel.notes.observe(this) { notes ->
            adapter.updateNotes(notes)
        }

        findViewById<FloatingActionButton>(R.id.addNoteButton).setOnClickListener {
            val newNote = Note(
                id = viewModel.notes.value?.size ?: 0,
                title = "New Note",
                content = "Content"
            )
            viewModel.addNote(newNote)
        }
    }
}