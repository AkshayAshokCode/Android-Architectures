package com.akshayashokcode.androidarchitectures.mvp.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshayashokcode.androidarchitectures.R
import com.akshayashokcode.androidarchitectures.mvp.model.Note
import com.akshayashokcode.androidarchitectures.mvp.model.NoteRepository
import com.akshayashokcode.androidarchitectures.mvp.presenter.NotePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MvpActivity : AppCompatActivity() , NoteView {

    private lateinit var presenter: NotePresenter
    private lateinit var adapter: NoteAdapter
    private lateinit var noteRepository: NoteRepository
    private lateinit var architectureTitleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        architectureTitleTextView = findViewById(R.id.architectureTitle)
        architectureTitleTextView.text = "MVP Architecture"

        noteRepository = NoteRepository()
        presenter = NotePresenter(this, noteRepository)

        val recyclerView = findViewById<RecyclerView>(R.id.noteList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = NoteAdapter(listOf())
        recyclerView.adapter = adapter

        presenter.loadNotes()

        findViewById<FloatingActionButton>(R.id.addNoteButton).setOnClickListener {
            val newNote = Note(
                id = presenter.getNotes().size,
                title = "New Note",
                content = "Content"
            )
            presenter.addNote(newNote)
        }
    }

    override fun displayNotes(notes: List<Note>) {
        adapter.updateNotes(notes)
    }

    override fun displayNoteAdded(note: Note) {
        adapter.notifyDataSetChanged()
    }

    override fun displayNoteDeleted(note: Note) {
        adapter.notifyDataSetChanged()
    }
}