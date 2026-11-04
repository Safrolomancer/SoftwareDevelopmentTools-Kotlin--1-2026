import service.NoteService
import model.Note
import utils.readNextInt
import utils.readNextString
import utils.readNextBoolean
import io.github.oshai.kotlinlogging.KotlinLogging
import java.io.File
import persistence.JSONSerializer



val noteService = NoteService(JSONSerializer(File("notes.json")))
private val logger = KotlinLogging.logger {}



fun mainMenu(): Int {
    logger.info { "Notes App Started" }

    print("""
         > ----------------------------------
         > |        NOTE KEEPER APP         |
         > ----------------------------------
         > | NOTE MENU                      |
         > |   1) Add a note                |
         > |   2) List all notes            |
         > |   3) Update a note             |
         > |   4) Delete a note             |
         > |   5) Archive a Note            |
         > |   6) Save notes                |
         > |   7) Load notes                |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
         > """.trimMargin(">"))

    return readNextInt("==>> ")
}




fun runMenu() {
    var input: Int

    do {
        input = mainMenu()

        when (input) {
            1 -> addNote()
            2 -> listNotes()
            3 -> updateNote()
            4 -> deleteNote()
            5 -> archiveNote()
            6 -> save()
            7 -> load()

            0 -> logger.info { "Notes App Exiting" }

            else -> println("Invalid Option")
        }

    } while (input != 0)
}


fun main(){

    runMenu()
}

fun addNote(){
    val title = readNextString("Title: ")

    val body = readNextString("Body: ")

    val priority = readNextInt("Priority (1-5): ")

    val category = readNextString("Category: ")

    noteService.addNote(
        Note(0, title, body, priority, category, false)
    )

    println("Note added")
}


fun listNotes() {
    val notes = noteService.getNotes()

    if (notes.isEmpty()) {
        println("No notes found.")
    } else {
        notes.forEach { println(it) }
    }
}


fun deleteNote() {
    val id = readNextInt("Enter ID to delete: ")

    if (noteService.deleteNote(id)) {
        println("Deleted")
    } else {
        println("Not found")
    }
}

fun updateNote() {
    val id = readNextInt("Enter ID to update: ")

    val title = readNextString("Title: ")

    val body = readNextString("Body: ")

    val priority = readNextInt("Priority (1-5): ")

    val category = readNextString("Category: ")

    val isArchived = readNextBoolean("Is archived (y/n): ")

    val updated = Note(id, title, body, priority, category, isArchived)

    if (noteService.updateNote(id, updated)) {
        println("Updated")
    } else {
        println("Not found")
    }
}


fun save() {
    try {
        noteService.store()
        println("Notes saved successfully.")
    } catch (e: Exception) {
        System.err.println("Error writing to file: $e")
    }
}

fun load() {
    try {
        noteService.load()
        println("Notes loaded successfully.")
    } catch (e: Exception) {
        System.err.println("Error reading from file: $e")
    }
}


fun archiveNote() {
    val activeNotes = noteService.getActiveNotes()

    if (activeNotes.isEmpty()) {
        println("No active notes available to archive.")
        return
    }

    println("Active notes:")
    activeNotes.forEach { println(it) }

    val id = readNextInt("Enter ID of note to archive: ")

    if (noteService.archiveNote(id)) {
        println("Note archived successfully.")
    } else {
        println("Note not found or already archived.")
    }
}




