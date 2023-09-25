import kotlinx.datetime.*

fun howManyDays(year1: Int, month1: Int, day1: Int, year2: Int, month2: Int, day2: Int): Int {
    return LocalDate(year1, month1, day1).daysUntil(LocalDate(year2, month2, day2))
}

fun main() {
    val (year1, month1, day1) = getData()
    val (year2, month2, day2) = getData()

    println(howManyDays(year1, month1, day1, year2, month2, day2))
}

private fun getData() = readln().split(" ").map { it.toInt() }