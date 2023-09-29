package tasklist

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

data class Task(
    var priorityTag: String,
    var dt: LocalDateTime,
    var lines: List<String>) {

    val dueTag get() = Utils.defineDueTag(dt.date)

    fun setDate(date: LocalDate) {
        dt = LocalDateTime(date.year, date.monthNumber, date.dayOfMonth, dt.hour, dt.minute)
    }
}
