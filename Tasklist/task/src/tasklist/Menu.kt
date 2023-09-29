package tasklist

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

class Menu {
    private val tasks = mutableListOf<Task>()

    fun run() {
        do {
            println("Input an action (add, print, edit, delete, end):")
            val cmd = readln().lowercase()
            when (cmd) {
                "add" -> add()
                "print" -> print()
                "edit" -> edit()
                "delete" -> delete()
                "end" -> break
                else -> println("The input action is invalid\n")
            }
        } while (true)
        println("Tasklist exiting!")
    }

    private fun add() {
        val p: String = inputPriority()
        val dt: LocalDateTime = inputTime(inputDate())

        inputTaskLines().also {
            if (it.isNotEmpty()) tasks.add(Task(p, dt, it))
        }
    }

    private fun inputTaskLines(): List<String> {
        println("Input a new task (enter a blank line to end):")
        return generateSequence { readln().trim() }
            .takeWhile { it.isNotEmpty() }
            .toList().also {
                if (it.isEmpty()) println("The task is blank")
            }
    }

    private fun inputPriority(): String {
        while (true) {
            println("Input the task priority (C, H, N, L):")
            readln().uppercase().let {
                if (Utils.isValidPriorityTag(it))
                    return it
            }
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

    private fun print() = TaskPrinter.print(tasks)

    private fun edit() {
        this.print()
        if (tasks.isEmpty()) return

        val task = tasks[inputTaskNumber() - 1]
        when (inputFieldToEdit()) {
            "priority" -> task.priorityTag = inputPriority()
            "date" -> task.setDate(inputDate())
            "time" -> task.dt = inputTime(task.dt.date)
            "task" -> inputTaskLines().let { if (it.isNotEmpty()) task.lines = it }
        }
        println("The task is changed")
    }

    private fun inputFieldToEdit(): String {
        while (true) {
            println("Input a field to edit (priority, date, time, task):")
            val field = readln()
            if (field !in Utils.EDIT_FIELDS) {
                println("Invalid field")
                continue
            }
            return field
        }
    }

    private fun delete() {
        this.print()
        if (tasks.isEmpty()) return

        tasks.removeAt(inputTaskNumber() - 1)
        println("The task is deleted")
    }

    private fun inputTaskNumber(): Int {
        while (true)
            try {
                println("Input the task number (1-${tasks.size}):")
                return readln().toInt().also {
                    if (it <= 0 || it > tasks.size) throw Exception()
                }
            } catch (_: Exception) {
                println("Invalid task number")
            }
    }
}