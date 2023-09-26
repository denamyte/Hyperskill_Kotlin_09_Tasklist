fun main() = readln()
    .groupBy { it }
    .count { it.value.size == 1 }
    .let(::println)