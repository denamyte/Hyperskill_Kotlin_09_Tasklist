package tasklist

class Menu {
    private val tasks = mutableListOf<List<String>>()

    fun run() {
        do {
            println("Input an action (add, print, end):")
            val cmd = readln().lowercase()
            when (cmd) {
                "add" -> add()
                "print" -> print()
                "end" -> break
                else -> println("The input action is invalid\n")
            }
        } while (true)
        println("Tasklist exiting!")
    }

    private fun add() {
        println("Input a new task (enter a blank line to end):")
        generateSequence { readln().trim() }
            .takeWhile { it.isNotEmpty() }
            .toList()
            .let {
                if (it.isEmpty()) println("The task is blank")
                else tasks.add(it)
            }
    }

    private fun print() {
        if (tasks.isEmpty()) "No tasks have been input"
        else {
            tasks.mapIndexed { i, task ->
                val s = "%-3d${task.first()}".format(i + 1)
                if (task.size == 1) s
                else s + "\n" + task.drop(1).joinToString("\n") { "   $it" }
            }.joinToString("\n\n")
        }
            .let(::println)
            .also { println() }
    }
}