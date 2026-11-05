
package utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NoteValidationTest {

    @Test
    fun `priority between 1 and 5 is valid`() {
        assertTrue(isValidPriority(1))
        assertTrue(isValidPriority(3))
        assertTrue(isValidPriority(5))
    }

    @Test
    fun `priority outside range is invalid`() {
        assertFalse(isValidPriority(0))
        assertFalse(isValidPriority(6))
        assertFalse(isValidPriority(-1))
    }

    @Test
    fun `category validation ignores case`() {
        assertEquals("Home", normalizeCategory("home"))
        assertEquals("College", normalizeCategory("COLLEGE"))
        assertEquals("Work", normalizeCategory("Work"))
    }

    @Test
    fun `invalid category returns null`() {
        assertNull(normalizeCategory("Unknown"))
    }

    @Test
    fun `status validation accepts valid values`() {
        assertEquals("todo", normalizeStatus("TODO"))
        assertEquals("doing", normalizeStatus("doing"))
        assertEquals("done", normalizeStatus("DONE"))
    }

    @Test
    fun `invalid status returns null`() {
        assertNull(normalizeStatus("waiting"))
    }

    @Test
    fun `tags are correctly parsed`() {
        val tags = parseTags("Kotlin, College, Testing")

        assertEquals(3, tags.size)
        assertTrue(tags.contains("Kotlin"))
        assertTrue(tags.contains("College"))
    }

    @Test
    fun `duplicate and empty tags are removed`() {
        val tags = parseTags("Kotlin, kotlin, , College")

        assertEquals(listOf("Kotlin", "College"), tags)
    }

    @Test
    fun `estimated hours must be valid`() {
        assertTrue(isValidEstimatedHours(0.0))
        assertTrue(isValidEstimatedHours(2.5))

        assertFalse(isValidEstimatedHours(-1.0))
        assertFalse(isValidEstimatedHours(Double.NaN))
    }
}
