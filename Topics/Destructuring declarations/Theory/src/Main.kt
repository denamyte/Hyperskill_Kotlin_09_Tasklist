import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File

// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
//    val baseDir = File("basedir")

//    if (baseDir.isDirectory) {
//        baseDir.walkBottomUp().maxByOrNull { f -> f.path.split(File.separator).size }
//            .also { println(it!!.path) }
//            .let { it!!.name }
//            .let { println(it) }
//    }

//    if (baseDir.isDirectory) {
//        baseDir.walkTopDown().filter { it.isDirectory && it.name != "basedir" }
//            .maxByOrNull { it.listFiles()!!.size }
//            .let { println("${it!!.name} ${it.listFiles()!!.size}") }
//    }

//    if (baseDir.isDirectory) {
//        baseDir.walkTopDown()
//            .filter { it.isDirectory && it.listFiles()!!.isEmpty() }
//            .joinToString(" ") { it.name }
//            .let(::println)
//    }

//    class Tourist(val name: String, val age: Int, val visitedCountries: Array<String>)
//
//    val moshi = Moshi.Builder()
//        .add(KotlinJsonAdapterFactory())
//        .build()
//
//    val touristAdapter = moshi.adapter(Tourist::class.java)
//
//    val touristString = """
//        {"name":"Jacky",
//        "age":23,
//        "visitedCountries":["Israel","Argentina", "Malaysia"]}""".trimIndent()
//
//    val newTourist = touristAdapter.fromJson(touristString)
//    newTourist?.visitedCountries.contentToString().let(::println)
}
