package tasklist

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.datetime.LocalDateTime
import java.io.File

class MoshiSaveLoad {
    companion object {
        class TaskSer(
            val p: String,
            val d: String,
            val t: List<String>)

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        private val taskListType = Types.newParameterizedType(List::class.java, TaskSer::class.java)
        private val taskListAdapter = moshi.adapter<List<TaskSer>>(taskListType)

        private const val FILE_NAME = "tasklist.json"

        fun save(tasks: List<Task>) {
            val tasksSer = tasks.map {
                TaskSer(
                    it.priorityTag,
                    it.dt.toString(),
                    it.lines
                )
            }

            val json = taskListAdapter.toJson(tasksSer)
            val file = File(FILE_NAME)
            if (!file.exists()) file.createNewFile()
            file.writeText(json)
        }

        fun load(): List<Task> {
            val file = File(FILE_NAME)
            if (!file.exists()) return listOf()
            val tasksSer = taskListAdapter.fromJson(file.readText())
                ?: return listOf()
            return tasksSer.map {
                Task(it.p, LocalDateTime.parse(it.d), it.t)
            }
        }
    }
}