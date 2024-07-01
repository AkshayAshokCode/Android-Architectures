package com.akshayashokcode.androidarchitectures.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshayashokcode.androidarchitectures.mvvm.model.Note
import com.akshayashokcode.androidarchitectures.mvvm.viewmodel.NoteViewModel
import com.akshayashokcode.androidarchitectures.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NoteViewModel
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.noteList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.notes.observe(this, Observer { notes ->
            adapter = NoteAdapter(notes)
            recyclerView.adapter = adapter
        })

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