package com.akshayashokcode.androidarchitectures.cleanMvvm.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Delete
import com.akshayashokcode.androidarchitectures.cleanMvvm.domain.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    suspend fun getNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
}