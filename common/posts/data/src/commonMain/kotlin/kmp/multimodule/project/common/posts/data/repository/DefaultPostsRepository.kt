package kmp.multimodule.project.common.posts.data.repository

import kmp.multimodule.project.common.posts.data.mapper.PostEntityMapper
import kmp.multimodule.project.common.posts.data.sqldelight.SqlDelightPostsDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import models.Post
import repository.PostsRepository
import kotlin.coroutines.CoroutineContext

internal class DefaultPostsRepository(
    private val localDataSource: SqlDelightPostsDataSource,
    private val postEntityMapper: PostEntityMapper,
    private val coroutineContext: CoroutineContext,
) : PostsRepository {
    override suspend fun fetchAllPosts(): Flow<List<Post>> = withContext(coroutineContext) {
        localDataSource.fetchAllPosts().map { postList ->
            postList.map(postEntityMapper::toPost)
        }
    }

    override suspend fun createPost(post: Post) = withContext(coroutineContext) {
        localDataSource.createPost(post = post)
    }
}