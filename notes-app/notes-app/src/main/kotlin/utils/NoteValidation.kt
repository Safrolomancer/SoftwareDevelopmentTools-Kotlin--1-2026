
package utils

private val allowedCategories = listOf(
    "Home", "College", "Work", "Social", "Hobbies"
)

private val allowedStatuses = listOf(
    "todo", "doing", "done"
)


fun isValidPriority(priority: Int): Boolean =
    priority in 1..5


fun normalizeCategory(category: String): String? =
    allowedCategories.firstOrNull {
        it.equals(category.trim(), ignoreCase = true)
    }


fun normalizeStatus(status: String): String? =
    allowedStatuses.firstOrNull {
        it.equals(status.trim(), ignoreCase = true)
    }


fun parseTags(input: String): List<String> =
    input.split(",")
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .distinctBy { it.lowercase() }


fun isValidEstimatedHours(hours: Double): Boolean =
    hours.isFinite() && hours >= 0.0



fun readValidatedPriority(): Int {
    while (true) {
        val priority = readNextInt("Priority (1-5): ")

        if (isValidPriority(priority)) {
            return priority
        }

        println("Priority must be between 1 and 5.")
    }
}

fun readValidatedCategory(): String {
    while (true) {
        val input = readNextString(
            "Category (Home, College, Work, Social, Hobbies): "
        )

        val category = normalizeCategory(input)

        if (category != null) {
            return category
        }

        println("Invalid category.")
    }
}

fun readValidatedStatus(): String {
    while (true) {
        val input = readNextString(
            "Status (todo, doing, done): "
        )

        val status = normalizeStatus(input)

        if (status != null) {
            return status
        }

        println("Invalid status.")
    }
}

fun readTags(): List<String> {
    val input = readNextString(
        "Tags (comma separated): "
    )

    return parseTags(input)
}

fun readValidatedEstimatedHours(): Double {
    while (true) {
        val input = readNextString(
            "Estimated hours: "
        )

        val hours = input.trim().toDoubleOrNull()

        if (hours != null && isValidEstimatedHours(hours)) {
            return hours
        }

        println("Enter a valid non-negative number.")
    }
}
