
package service

import model.NoteItem
import persistence.Serializer
import persistence.JSONSerializer
import java.io.File

class NoteItemService(
    private val serializer: Serializer = JSONSerializer(File("note-items.json"))
) {

    private var noteItems = ArrayList<NoteItem>()

    fun addItemToNote(noteId: Int, itemId: Int): Boolean {
        val relationshipExists = noteItems.any {
            it.noteId == noteId && it.itemId == itemId
        }

        if (relationshipExists) {
            return false
        }

        noteItems.add(
            NoteItem(
                noteId = noteId,
                itemId = itemId
            )
        )

        return true
    }

    fun getItemIdsForNote(noteId: Int): List<Int> =
        noteItems
            .filter { it.noteId == noteId }
            .map { it.itemId }

    fun store() {
        serializer.write(noteItems)
    }

    fun load() {
        val array = serializer.read(Array<NoteItem>::class.java)
        noteItems = array.toCollection(ArrayList())
    }
}
