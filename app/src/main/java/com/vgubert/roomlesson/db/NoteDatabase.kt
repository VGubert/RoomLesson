package com.vgubert.roomlesson.db

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vgubert.roomlesson.db.dao.NoteDao
import com.vgubert.roomlesson.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        private var database: NoteDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            return if(database == null) {
                database = Room.databaseBuilder(context, NoteDatabase::class.java, "db").build()
                database as NoteDatabase
            } else {
                database as NoteDatabase
            }
        }
    }
}