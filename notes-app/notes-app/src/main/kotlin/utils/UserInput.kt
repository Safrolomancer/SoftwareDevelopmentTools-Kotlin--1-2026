package utils

fun readNextInt(prompt: String = ""): Int {
    while (true) {
        print(prompt)

        val value = readln().trim().toIntOrNull()

        if (value != null) {
            return value
        }

        println("Please enter a valid integer.")
    }
}

fun readNextString(prompt: String = ""): String {
    print(prompt)
    return readlnOrNull() ?: ""
}

fun readNextBoolean(prompt: String = ""): Boolean {
    while (true) {
        print(prompt)
        when (readlnOrNull()?.trim()?.lowercase()) {
            "y", "yes", "true" -> return true
            "n", "no", "false" -> return false
            null -> return false
            else -> println("Please enter y or n.")
        }
    }
}