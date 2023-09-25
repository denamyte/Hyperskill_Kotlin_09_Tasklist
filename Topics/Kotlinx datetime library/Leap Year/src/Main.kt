fun isLeapYear(year: String) = year.toInt().let { it % 4 == 0 && it % 400 != 0 }

fun main() {
    val year = readln()
    println(isLeapYear(year))
}