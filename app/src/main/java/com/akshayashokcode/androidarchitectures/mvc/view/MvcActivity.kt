package com.akshayashokcode.androidarchitectures.mvc.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshayashokcode.androidarchitectures.R
import com.akshayashokcode.androidarchitectures.mvc.controller.NoteController
import com.akshayashokcode.androidarchitectures.mvc.model.NoteRepository
import com.akshayashokcode.androidarchitectures.mvc.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MvcActivity : AppCompatActivity() {

    private lateinit var controller: NoteController
    private lateinit var adapter: NoteAdapter
    private lateinit var noteRepository: NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteRepository = NoteRepository()
        controller = NoteController(noteRepository)

        val recyclerView = findViewById<RecyclerView>(R.id.noteList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = NoteAdapter(controller.getNotes())
        recyclerView.adapter = adapter

        findViewById<FloatingActionButton>(R.id.addNoteButton).setOnClickListener {
            val newNote = Note(
                id = controller.getNotes().size,
                title = "New Note",
                content = "Content"
            )
            controller.addNote(newNote)
            adapter.notifyDataSetChanged() // Notify adapter directly
        }
    }
}