package kmp.multimodule.project.common.posts.api.repository

import kotlinx.coroutines.flow.Flow
import kmp.multimodule.project.common.posts.api.models.Post

interface PostsRepository {
    suspend fun observePosts(): Flow<List<Post>>
    suspend fun refreshPosts()
    suspend fun createPost(post: Post)
    suspend fun clearCache()
}
