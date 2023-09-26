fun main() {
    val rowCol = Array(2) { MutableList(5) { it + 1 } }
    repeat(3) {
        readln().split(" ")
            .map(String::toInt)
            .let {
                rowCol.first().remove(it.first())
                rowCol.last().remove(it.last())
            }
    }
    rowCol.map { it.joinToString(" ") }.forEach(::println)
}