package tasklist

import kotlinx.datetime.LocalDateTime

data class Task(
    val priority: Priority,
    val dt: LocalDateTime,
    val lines: List<String>) {

    val dateTimePriority: String get() {
        val dtStr = dt.toString()
        return buildString {
            append(dtStr.substring(0, 10))
            append(" ")
            append(dtStr.substring(11, 16))
            append(" ")
            append(priority.label)
        }
    }
}
