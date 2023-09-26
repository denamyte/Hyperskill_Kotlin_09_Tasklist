package tasklist

class Utils {
    companion object {
        private val DATE_REGEX = Regex("""\d{4}(-\d{1,2}){1,2}""")
        fun checkDate(raw: String): String {
            if (DATE_REGEX.matches(raw)) return raw
            else throw Exception()
        }

        private val TIME_REGEX = Regex("""\d{1,2}:\d{1,2}""")
        fun checkTime(raw: String): String {
            if (TIME_REGEX.matches(raw)) return raw
            else throw Exception()
        }
    }
}