package com.vgubert.roomlesson.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vgubert.roomlesson.REPOSITORY
import com.vgubert.roomlesson.db.NoteDatabase
import com.vgubert.roomlesson.db.repository.NoteRealisation
import com.vgubert.roomlesson.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealisation(daoNote)
    }
    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}