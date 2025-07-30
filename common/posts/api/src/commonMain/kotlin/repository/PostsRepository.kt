package repository

import models.Post

interface PostsRepository {
    suspend fun fetchAllPosts(): List<Post>
    suspend fun searchPosts(query: String): List<Post>
}
