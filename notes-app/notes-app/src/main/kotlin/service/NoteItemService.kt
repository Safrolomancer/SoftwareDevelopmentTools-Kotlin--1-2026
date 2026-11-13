package service

import model.NoteItem

class NoteItemService {

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
}
