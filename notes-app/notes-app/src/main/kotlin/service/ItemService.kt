package service

import model.Item

class ItemService {

    private val items = ArrayList<Item>()
    private var lastId = 0

    fun addItem(item: Item) {
        item.id = lastId++
        items.add(item)
    }

    fun findById(id: Int): Item? =
        items.find { it.id == id }

    fun getItems(): List<Item> = items
}
