
package service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NoteItemServiceTest {

    @Test
    fun `adding an item to a note returns true`() {
        val service = NoteItemService()

        assertTrue(service.addItemToNote(1, 3))
    }

    @Test
    fun `duplicate relationship is rejected`() {
        val service = NoteItemService()

        assertTrue(service.addItemToNote(1, 3))
        assertFalse(service.addItemToNote(1, 3))
    }

    @Test
    fun `same item can be linked to different notes`() {
        val service = NoteItemService()

        assertTrue(service.addItemToNote(1, 3))
        assertTrue(service.addItemToNote(2, 3))
    }

    @Test
    fun `get item IDs for a note`() {
        val service = NoteItemService()

        service.addItemToNote(1, 3)
        service.addItemToNote(1, 5)
        service.addItemToNote(2, 7)

        assertEquals(listOf(3, 5), service.getItemIdsForNote(1))
    }
}
