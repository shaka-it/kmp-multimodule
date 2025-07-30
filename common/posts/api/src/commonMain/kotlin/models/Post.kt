package models

data class Post(
    val id: String = "",
    val order: Long = 0L,
    val text: String = "",
    val isDone: Boolean = false,
)