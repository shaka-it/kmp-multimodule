package kmp.multimodule.project.common.posts.api.models

data class Post(
    val id: String = "",
    val title: String,
    val description: String,
    val author: String = "",
)