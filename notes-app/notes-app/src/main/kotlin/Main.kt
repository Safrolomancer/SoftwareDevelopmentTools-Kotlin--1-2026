import service.NoteService
import model.Note

val noteService = NoteService()

fun mainMenu(): Int {
    print(""" 
         > ----------------------------------
         > |        NOTE KEEPER APP         |
         > ----------------------------------
         > | NOTE MENU                      |
         > |   1) Add a note                |
         > |   2) List all notes            |
         > |   3) Update a note             |
         > |   4) Delete a note             |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
         > ==>> """.trimMargin(">"))
    return readlnOrNull()?.toIntOrNull() ?: -1
}



fun runMenu (){
    var input : Int
    do {
        input = mainMenu()
        when(input) {
            1 -> addNote()
            2 -> listNotes()
            3 -> println("Update")
            4 -> println("Delete")
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
    } while (input != -1)
}

fun main(){

    runMenu()
}

fun addNote(){
    print("Title: ")
    val title = readlnOrNull() ?: ""

    print("Body: ")
    val body = readlnOrNull() ?: ""

    print("Priority (1-5): ")
    val priority = readlnOrNull()?.toIntOrNull() ?: 1

    print("Category: ")
    val category = readlnOrNull() ?: ""

    noteService.addNote(
        Note(0, title, body, priority, category, false)
    )

    println("Note added")
}

fun listNotes() {
    println(noteService.getNotes())
}


