package com.project.notesapp.viewmodel

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.project.notesapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application,private val noteRepository: NoteRepository): AndroidViewModel(app) {

    fun addNote(note: com.project.notesapp.model.Note) =
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }


    fun deleteNote(note: com.project.notesapp.model.Note) =
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }


    fun updateNote(note: com.project.notesapp.model.Note) =
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }

    fun getAllNotes() = noteRepository.getAllNotes()

    fun searchNote(query: String?) =
        noteRepository.searchNote(query)

}