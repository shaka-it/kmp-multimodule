package repository

import ktor.KtorPostsDataSource
import ktor.mapper.PostResponseMapper
import models.Post
import sqldelight.SqlDelightPostsDataSource

internal class DefaultPostsRepository(
    private val remoteDataSource: KtorPostsDataSource,
    private val localDataSource: SqlDelightPostsDataSource,
    private val postResponseMapper: PostResponseMapper,
) : PostsRepository {
    override suspend fun fetchAllPosts(): List<Post> {
        return remoteDataSource.fetchAllPosts().map(postResponseMapper::toGame)
    }

    override suspend fun searchPosts(query: String): List<Post> {
        return remoteDataSource.searchPost(query).map(postResponseMapper::toGame)
    }
}