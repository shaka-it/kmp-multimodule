package models

data class Todo(
    val id: String = "",
    val order: Long = 0L,
    val text: String = "",
    val isDone: Boolean = false,
)