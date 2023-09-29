package tasklist

import kotlinx.datetime.*

class Utils {
    companion object {
        private const val PRIORITIES = "CHNL"
        fun isValidPriorityTag(tag: String) = tag.length == 1 && tag in PRIORITIES

        private val DATE_REGEX = Regex("""\d{4}(-\d{1,2}){1,2}""")
        fun checkDate(s: String): String = checkDT(DATE_REGEX, s)

        private val TIME_REGEX = Regex("""\d{1,2}:\d{1,2}""")
        fun checkTime(s: String): String = checkDT(TIME_REGEX, s)

        private fun checkDT(r: Regex, s: String): String {
            if (r.matches(s)) return s
            else throw Exception()
        }

        private val TODAY = Clock.System.now().toLocalDateTime(TimeZone.UTC).date
        fun defineDueTag(dt: LocalDate): String = TODAY.daysUntil(dt).let {
            when {
                it == 0 -> "T"
                it > 0 -> "I"
                else -> "O"
            }
        }

        val EDIT_FIELDS = arrayOf("priority", "date", "time", "task")
    }
}