
package service

import model.Item
import persistence.Serializer
import persistence.JSONSerializer
import java.io.File

class ItemService(
    private val serializer: Serializer = JSONSerializer(File("items.json"))
) {

    private var items = ArrayList<Item>()
    private var lastId = 0

    fun addItem(item: Item) {
        item.id = lastId++
        items.add(item)
    }

    fun findById(id: Int): Item? =
        items.find { it.id == id }

    fun getItems(): List<Item> = items

    fun store() {
        serializer.write(items)
    }

    fun load() {
        val array = serializer.read(Array<Item>::class.java)
        items = array.toCollection(ArrayList())

        lastId = (items.maxOfOrNull { it.id } ?: -1) + 1
    }
}
