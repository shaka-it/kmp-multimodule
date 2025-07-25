package repository

import ktor.KtorPostsDataSource
import ktor.mapper.PostResponseMapper
import models.Game
import sqldelight.SqlDelightPostsDataSource

internal class DefaultPostsRepository(
    private val remoteDataSource: KtorPostsDataSource,
    private val localDataSource: SqlDelightPostsDataSource,
    private val postResponseMapper: PostResponseMapper,
) : PostsRepository {
    override suspend fun fetchAllPosts(): List<Game> {
        return remoteDataSource.fetchAllPosts().map(postResponseMapper::toGame)
    }

    override suspend fun searchPosts(query: String): List<Game> {
        return remoteDataSource.searchPost(query).map(postResponseMapper::toGame)
    }
}