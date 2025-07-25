package repository

import models.Game

interface PostsRepository {
    suspend fun fetchAllPosts(): List<Game>
    suspend fun searchPosts(query: String): List<Game>
}
