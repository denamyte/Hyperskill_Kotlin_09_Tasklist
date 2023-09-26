package tasklist

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

class Menu {
    private val tasks = mutableListOf<Task>()

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
        val p = inputPriority()
        val dt = inputTime(inputDate())

        println("Input a new task (enter a blank line to end):")
        generateSequence { readln().trim() }
            .takeWhile { it.isNotEmpty() }
            .toList()
            .let { lines ->
                if (lines.isEmpty()) println("The task is blank")
                else tasks.add(Task(p, dt, lines))
            }
    }

    private fun inputPriority(): Priority {
        while (true) {
            println("Input the task priority (C, H, N, L):")
            try {
                return Priority.fromLabel(readln().uppercase())
            } catch (_: Exception) { }
        }
    }

    private fun inputDate(): LocalDate {
        while (true) {
            println("Input the date (yyyy-mm-dd):")
            try {
                val (y, m, d) = Utils.checkDate(readln())
                    .split("-").map(String::toInt)
                return LocalDate(y, m, d)
            } catch (_: Exception) {
                println("The input date is invalid")
            }
        }
    }

    private fun inputTime(date: LocalDate): LocalDateTime {
        while (true) {
            println("Input the time (hh:mm):")
            try {
                val (h, min) = Utils.checkTime(readln())
                    .split(":").map(String::toInt)
                return LocalDateTime(date.year, date.monthNumber, date.dayOfMonth, h, min)
            } catch (_: Exception) {
                println("The input time is invalid")
            }
        }
    }

    private fun print() {
        if (tasks.isEmpty()) "No tasks have been input"
        else {
            tasks.mapIndexed { i, task ->
                "%-3d${task.dateTimePriority}\n".format(i + 1) +
                        task.lines.joinToString("\n") { "   $it" }
            }.joinToString("\n\n")
        }
            .let(::println)
            .also { println() }
    }
}