fun main(args: Array<String>) {
    val list = intArrayOf(2, 5, 3, 4)
    val largestNumber = findLargest(list)
    println("Largest number is: $largestNumber")
}

fun findLargest(list: IntArray): Int {
    var index = 0
    var max = Int.MAX_VALUE

    while (index <= list.size) {
        if (list[index] > max) {
            max = list[index]
        }
        index++
    }
    return max
}
