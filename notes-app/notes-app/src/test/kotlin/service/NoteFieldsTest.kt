
package service

import model.Note
import persistence.JSONSerializer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.io.TempDir
import java.io.File

class NoteFieldsTest {

    @Test
    fun `new note fields have default values`() {
        val note = Note(title = "Test")

        assertEquals("todo", note.status)
        assertTrue(note.tags.isEmpty())
        assertEquals(0.0, note.estimatedHours)
    }

    @Test
    fun `new fields are preserved after JSON persistence`(
        @TempDir tempDir: File
    ) {
        val file = File(tempDir, "notes.json")

        val original = NoteService(JSONSerializer(file))

        original.addNote(
            Note(
                title = "Learn Kotlin",
                body = "Complete lambdas lab",
                priority = 3,
                category = "College",
                status = "doing",
                tags = listOf("Kotlin", "Lab"),
                estimatedHours = 2.5
            )
        )

        original.store()

        val loaded = NoteService(JSONSerializer(file))
        loaded.load()

        val note = loaded.getNotes().single()

        assertEquals("doing", note.status)
        assertEquals(listOf("Kotlin", "Lab"), note.tags)
        assertEquals(2.5, note.estimatedHours)
    }
}
