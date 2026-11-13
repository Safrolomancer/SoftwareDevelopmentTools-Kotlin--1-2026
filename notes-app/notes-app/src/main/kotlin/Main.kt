import model.Item
import service.ItemService
import service.NoteItemService
import service.NoteService
import model.Note
import utils.readNextInt
import utils.readNextString
import utils.readNextBoolean
import io.github.oshai.kotlinlogging.KotlinLogging
import java.io.File
import persistence.JSONSerializer
import utils.readValidatedPriority
import utils.readValidatedCategory
import utils.readValidatedStatus
import utils.readValidatedEstimatedHours
import utils.readTags


val noteService = NoteService(JSONSerializer(File("notes.json")))
private val logger = KotlinLogging.logger {}
val itemService = ItemService()
val noteItemService = NoteItemService()


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
         > |   8) Reports                   |
         > |   9) Find note by ID          |
         > |   10) Search notes by content |
         > |   11) Create an item          |
         > |   12) Add item to a note      |
         > |   13) View items for a note   |
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
            10 -> searchNotes()
            11 -> createItem()
            12 -> addItemToNote()
            0 -> logger.info { "Notes App Exiting" }

            else -> println("Invalid Option")
        }

    } while (input != 0)
}


fun searchNotes() {
    val search = readNextString("Enter text to search: ")

    val results = noteService.searchNotesByContent(search)

    if (results.isEmpty()) {
        println("No notes found")
    } else {
        println("Found ${results.size} note(s):")
        results.forEach { println(it) }
    }
}



fun main(){

    runMenu()
}


fun addNote() {
    val title = readNextString("Title: ")
    val body = readNextString("Body: ")

    val priority = readValidatedPriority()
    val category = readValidatedCategory()

    val status = readValidatedStatus()
    val tags = readTags()
    val estimatedHours = readValidatedEstimatedHours()

    val note = Note(
        title = title,
        body = body,
        priority = priority,
        category = category,
        status = status,
        tags = tags,
        estimatedHours = estimatedHours
    )

    noteService.addNote(note)

    println("Note added successfully.")
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

    val existingNote = noteService.findNoteById(id)

    if (existingNote == null) {
        println("Note not found.")
        return
    }

    val title = readNextString("Title: ")
    val body = readNextString("Body: ")

    val priority = readValidatedPriority()
    val category = readValidatedCategory()

    val isArchived = readNextBoolean("Is archived (y/n): ")

    val status = readValidatedStatus()
    val tags = readTags()
    val estimatedHours = readValidatedEstimatedHours()

    val updated = existingNote.copy(
        title = title,
        body = body,
        priority = priority,
        category = category,
        isArchived = isArchived,
        status = status,
        tags = tags,
        estimatedHours = estimatedHours
    )

    if (noteService.updateNote(id, updated)) {
        println("Note updated successfully.")
    } else {
        println("Update failed.")
    }
}




fun save() {
    try {
        noteService.store()
        itemService.store()
        noteItemService.store()

        println("Notes, Items and relationships saved successfully.")
    } catch (e: Exception) {
        System.err.println("Error saving data: ${e.message}")
    }
}

fun load() {
    try {
        noteService.load()
        itemService.load()
        noteItemService.load()

        println("Notes, Items and relationships loaded successfully.")
    } catch (e: Exception) {
        System.err.println("Error loading data: ${e.message}")
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

fun createItem() {
    val name = readNextString("Enter item name: ").trim()

    if (name.isEmpty()) {
        println("Item name cannot be empty.")
        return
    }

    val item = Item(name = name)
    itemService.addItem(item)

    println("Item created with ID: ${item.id}")
}


fun addItemToNote() {
    val noteId = readNextInt("Enter Note ID: ")

    if (noteService.findNoteById(noteId) == null) {
        println("Note not found.")
        return
    }

    val itemId = readNextInt("Enter Item ID: ")

    if (itemService.findById(itemId) == null) {
        println("Item not found.")
        return
    }

    val added = noteItemService.addItemToNote(noteId, itemId)

    if (added) {
        println("Item successfully added to note.")
    } else {
        println("This item is already linked to this note.")
    }
}

fun viewItemsForNote() {
    val noteId = readNextInt("Enter Note ID: ")

    if (noteService.findNoteById(noteId) == null) {
        println("Note not found.")
        return
    }

    val itemIds = noteItemService.getItemIdsForNote(noteId)

    if (itemIds.isEmpty()) {
        println("No items found for this note.")
        return
    }

    println("Items for Note $noteId:")

    itemIds.forEach { itemId ->
        val item = itemService.findById(itemId)

        if (item != null) {
            println("ID: ${item.id} | Name: ${item.name}")
        }
    }
}





