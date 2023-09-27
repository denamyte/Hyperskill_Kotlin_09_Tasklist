package tasklist

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

data class Task(
    var priorityTag: String,
    var dt: LocalDateTime,
    var lines: List<String>) {

    val dueTag get() = Utils.defineDueTag(dt.date)

    val dateTimePriority: String get() {
        val dtStr = dt.toString()
        return listOf(
            dtStr.substring(0, 10),
            dtStr.substring(11, 16),
            priorityTag,
            dueTag
        ).joinToString(" ")
    }

    fun setDate(date: LocalDate) {
        dt = LocalDateTime(date.year, date.monthNumber, date.dayOfMonth, dt.hour, dt.minute)
    }
}
