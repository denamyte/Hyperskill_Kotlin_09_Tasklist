data class Comment(val id: Int, val body: String, val author: String)

fun printComments(commentsData: MutableList<Comment>) = commentsData.joinToString("\n") {
    (_, body, author) -> "Author: $author; Text: $body"}.let(::println)
