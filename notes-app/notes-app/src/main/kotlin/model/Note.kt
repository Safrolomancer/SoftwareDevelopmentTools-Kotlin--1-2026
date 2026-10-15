
package model

data class Note(
    var id: Int,
    var title: String,
    var body: String,
    var priority: Int,
    var category: String,
    var isArchived: Boolean
) {
    override fun toString(): String {
        return """
            ------------------------------
            ID: $id
            Title: $title
            Body: $body
            Priority: $priority
            Category: $category
            Archived: $isArchived
            ------------------------------
        """.trimIndent()
    }
}

