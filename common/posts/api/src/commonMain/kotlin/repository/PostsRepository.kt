package repository

import kotlinx.coroutines.flow.Flow
import models.Post

interface PostsRepository {
    suspend fun fetchAllPosts(): Flow<List<Post>>
    suspend fun createPost(post: Post)
}
