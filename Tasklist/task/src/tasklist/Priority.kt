package tasklist

enum class Priority(val label: String) {
    Critical("C"),
    High("H"),
    Normal("N"),
    Low("L");

    companion object {
        private val LABEL_TO_PRIORITY = values().associateBy { it.label }
        fun fromLabel(label: String) = LABEL_TO_PRIORITY[label]!!
    }
}