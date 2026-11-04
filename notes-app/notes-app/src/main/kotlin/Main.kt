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
         > |   2) List notes                |
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
            8 -> reportsMenu()
            9 -> findNote()
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
    println("""
        ----------------------------------
        |          LIST NOTES            |
        ----------------------------------
        | 1) List all notes              |
        | 2) List active notes           |
        | 3) List archived notes         |
        | 4) List notes by category      |
        | 5) List notes by priority      |
        | 0) Back                        |
        ----------------------------------
    """.trimIndent())

    when (readNextInt("==>> ")) {
        1 -> displayNotes(noteService.getNotes())

        2 -> displayNotes(noteService.getActiveNotes())

        3 -> displayNotes(noteService.getArchivedNotes())

        4 -> {
            val category = readNextString("Enter category: ")
            displayNotes(noteService.getNotesByCategory(category))
        }

        5 -> {
            val priority = readNextInt("Enter priority: ")
            displayNotes(noteService.getNotesByPriority(priority))
        }

        0 -> return

        else -> println("Invalid option")
    }
}


fun displayNotes(notes: List<Note>) {
    println("Number of notes: ${notes.size}")

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


fun reportsMenu() {
    println("""
        ----------------------------------
        |          REPORTS               |
        ----------------------------------
        | 1) Total notes                 |
        | 2) Active notes count          |
        | 3) Archived notes count        |
        | 4) Count by category           |
        | 5) Count by priority           |
        | 0) Back                        |
        ----------------------------------
    """.trimIndent())

    when (readNextInt("==>> ")) {
        1 -> println("Total notes: ${noteService.numberOfNotes()}")

        2 -> println("Active notes: ${noteService.numberOfActiveNotes()}")

        3 -> println("Archived notes: ${noteService.numberOfArchivedNotes()}")

        4 -> {
            val category = readNextString("Enter category: ")
            println("Count: ${noteService.numberOfNotesByCategory(category)}")
        }

        5 -> {
            val priority = readNextInt("Enter priority: ")
            println("Count: ${noteService.numberOfNotesByPriority(priority)}")
        }

        0 -> return

        else -> println("Invalid option")
    }
}

fun findNote() {
    val id = readNextInt("Enter note ID: ")
    val note = noteService.findNoteById(id)

    if (note == null) {
        println("Note not found.")
    } else {
        println(note)
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

}




