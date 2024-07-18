package com.akshayashokcode.androidarchitectures.mvi.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshayashokcode.androidarchitectures.R
import com.akshayashokcode.androidarchitectures.mvi.model.Note
import com.akshayashokcode.androidarchitectures.mvi.model.NoteIntent
import com.akshayashokcode.androidarchitectures.mvi.model.NoteState
import com.akshayashokcode.androidarchitectures.mvi.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MviActivity : AppCompatActivity() {

    private val viewModel: NoteViewModel by viewModels()
    private lateinit var adapter: NoteAdapter
    private lateinit var architectureTitleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        architectureTitleTextView = findViewById(R.id.architectureTitle)
        architectureTitleTextView.text = "MVI Architecture"
        setupRecyclerView()

        observeViewModel()
        viewModel.processIntent(NoteIntent.LoadNotes)

        findViewById<FloatingActionButton>(R.id.addNoteButton).setOnClickListener {
          viewModel.processIntent(NoteIntent.AddNote("New Note", "content"))
            }
        }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.noteList)
        adapter = NoteAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is NoteState.Loading -> showLoading()
                is NoteState.Notes -> showNotes(state.notes)
                is NoteState.Error -> showError(state.error)
            }
        }
    }

    private fun showLoading() {
        // Show loading state in the UI
    }

    private fun showNotes(notes: List<Note>) {
        // Display the list of notes in the RecyclerView
        adapter.updateNotes(notes)
    }

    private fun showError(error: String) {
        // Display error message in the UI
    }
}