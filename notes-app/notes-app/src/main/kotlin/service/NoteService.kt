package service

import model.Note
import persistence.Serializer

class NoteService(serializerType: Serializer) {

    private var serializer: Serializer = serializerType

    private var notes = ArrayList<Note>()
    private var lastId = 0

    private fun getId(): Int = lastId++

    fun addNote(note: Note) {
        note.id = getId()
        note.isArchived = false
        notes.add(note)
    }

    fun getNotes(): List<Note> {
        return notes
    }

    // XML / JSON Persistence

    fun load() {
        val array = serializer.read(Array<Note>::class.java)
        notes = array.toCollection(ArrayList())
        lastId = (notes.maxOfOrNull { it.id } ?: -1) + 1
    }

    fun store() {
        serializer.write(notes)
    }

    // Listing Methods - Kotlin Lambdas

    fun getActiveNotes(): List<Note> =
        notes.filter { !it.isArchived }

    fun getArchivedNotes(): List<Note> =
        notes.filter { it.isArchived }

    fun getNotesByCategory(category: String): List<Note> =
        notes.filter {
            it.category.equals(category, ignoreCase = true)
        }

    fun getNotesByPriority(priority: Int): List<Note> =
        notes.filter { it.priority == priority }

    // Searching Methods - Kotlin Lambdas

    fun findNoteById(id: Int): Note? =
        notes.find { it.id == id }

    fun searchNotesByContent(search: String): List<Note> =
        notes.filter {
            it.title.contains(search, ignoreCase = true) ||
                    it.body.contains(search, ignoreCase = true)
        }

    // Delete and Update Methods

    fun deleteNote(id: Int): Boolean {
        return notes.removeIf { it.id == id }
    }

    fun updateNote(id: Int, updated: Note): Boolean {
        val index = notes.indexOfFirst { it.id == id }

        if (index != -1) {
            notes[index] = updated.copy(id = notes[index].id)
            return true
        }

        return false
    }

    // Counting Methods - Kotlin Lambdas

    fun numberOfNotes(): Int =
        notes.count()

    fun numberOfArchivedNotes(): Int =
        notes.count { it.isArchived }

    fun numberOfActiveNotes(): Int =
        notes.count { !it.isArchived }

    fun numberOfNotesByCategory(category: String): Int =
        notes.count { it.category == category }

    fun numberOfNotesByPriority(priority: Int): Int =
        notes.count { it.priority == priority }

    // Archiving

    fun archiveNote(id: Int): Boolean {
        val note = notes.find {
            it.id == id && !it.isArchived
        }

        if (note != null) {
            note.isArchived = true
            return true
        }

        return false
    }
}

