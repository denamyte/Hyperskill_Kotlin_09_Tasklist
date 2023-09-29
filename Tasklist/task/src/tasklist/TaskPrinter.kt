package tasklist

private const val CHUNK_SIZE = 44
private const val TASK_SEPARATOR = "+----+------------+-------+---+---+--------------------------------------------+"
private const val CAPTION = TASK_SEPARATOR + "\n" +
        "| N  |    Date    | Time  | P | D |                   Task                     |\n" +
        TASK_SEPARATOR
private const val TASK_FIRST_LINE = "| %-2d | %s | %s | %s | %s |%-44s|"
private const val TASK_LINE = "|    |            |       |   |   |%-44s|"

private val P_COLORED_TAGS = mapOf(
    "C" to "\u001b[101m \u001b[0m",
    "H" to "\u001b[103m \u001b[0m",
    "N" to "\u001b[102m \u001b[0m",
    "L" to "\u001b[104m \u001b[0m",
)
private val D_COLORED_TAGS = mapOf(
    "I" to "\u001b[102m \u001b[0m",
    "T" to "\u001b[103m \u001b[0m",
    "O" to "\u001b[101m \u001b[0m",
)

class TaskPrinter {
    companion object {
        fun print(tasks: List<Task>) {
            if (tasks.isEmpty()) {
                println("No tasks have been input")
                return
            }

            println(CAPTION)
            tasks.forEachIndexed(this::print)
        }

        private fun print(index: Int, task: Task) {
            val lines = task.lines.map { it.chunked(CHUNK_SIZE) }.flatten()
            val date = task.dt.toString()

            println(TASK_FIRST_LINE.format(
                index + 1,
                date.substring(0, 10),
                date.substring(11, 16),
                P_COLORED_TAGS[task.priorityTag],
                D_COLORED_TAGS[task.dueTag],
                lines.first()))

            lines.drop(1).forEach { println(TASK_LINE.format(it)) }

            println(TASK_SEPARATOR)
        }
    }
}