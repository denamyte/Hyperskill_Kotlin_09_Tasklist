package tasklist

fun main() {
    println("Input the tasks (enter a blank line to end):")
    generateSequence { readln().trim() }
        .takeWhile(String::isNotEmpty)
        .mapIndexed { i, s -> "%-3d$s".format(i + 1) }
        .joinToString("\n")
        .ifEmpty { "No tasks have been input" }
        .let(::println)
}


