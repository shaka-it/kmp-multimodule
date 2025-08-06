package kmp.multimodule.project.common.posts.presentation.mapper

import kmp.multimodule.project.common.posts.presentation.model.PostDvo
import kmp.multimodule.project.common.posts.api.models.Post

class PostDvoMapper {
    fun toPostDvo(from: Post): PostDvo {
        return PostDvo(
            title = from.title,
            description = from.description,
            author = from.author,
        )
    }
}