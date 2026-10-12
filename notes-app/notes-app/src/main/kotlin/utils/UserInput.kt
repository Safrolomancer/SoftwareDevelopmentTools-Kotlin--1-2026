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