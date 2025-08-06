package kmp.multimodule.project.common.posts.data.mapper

import kmp.multimodule.project.common.posts.api.models.Post
import kmp.multimodule.project.common.posts.data.ktor.models.KtorCreatePostRequest
import kmp.multimodule.project.common.posts.data.ktor.models.KtorFetchPostResponse
import kmp.multimodule.project.db.PostEntity

internal class PostMapper {
    fun toPost(from: PostEntity): Post {
        return Post(
            id = from.id,
            title = from.title,
            description = from.description,
            author = from.author,
        )
    }

    fun toPost(from: KtorFetchPostResponse): Post {
        return Post(
            id = from.postId,
            title = from.title,
            description = from.description,
            author = from.author,
        )
    }

    fun toPostRequest(from: Post): KtorCreatePostRequest {
        return KtorCreatePostRequest(
            title = from.title,
            description = from.description,
        )
    }
}