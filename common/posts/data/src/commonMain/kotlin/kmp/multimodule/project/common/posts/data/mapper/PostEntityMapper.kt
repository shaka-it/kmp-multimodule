package kmp.multimodule.project.common.posts.data.mapper

import kmp.multimodule.project.db.PostEntity
import models.Post

internal class PostEntityMapper {
    fun toPost(from: PostEntity): Post {
        return Post(
            id = from.id,
            title = from.title,
            description = from.description,
        )
    }
}