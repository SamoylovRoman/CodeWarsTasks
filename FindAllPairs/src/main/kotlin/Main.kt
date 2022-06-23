fun main(args: Array<String>) {
    println(duplicates2(intArrayOf(1, 2, 5, 6, 5, 2)))
    println(duplicates2(intArrayOf(1, 2, 2, 20, 6, 20, 2, 6, 2)))
    println(duplicates2(intArrayOf(0, 0, 0, 0, 0, 0, 0)))
}

// my ugly solution
fun duplicates(array: IntArray): Int {
    if (array.isEmpty() || array.size == 1) return 0
    var count = 0
    val map = emptyMap<Int, Int>().toMutableMap()
    array.forEach {
        map[it] = if (!map.containsKey(it)) 1 else map[it]!! + 1
    }
    map.forEach { entry ->
        if (entry.value >= 2) count += (entry.value / 2)
    }
    return count
}

// one pretty solution
fun duplicates2(array: IntArray) = array.groupBy { it }.map { it.value.size / 2 }.sum()