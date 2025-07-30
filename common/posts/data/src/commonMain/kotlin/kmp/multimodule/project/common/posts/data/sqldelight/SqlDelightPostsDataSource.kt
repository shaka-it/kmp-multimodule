package kmp.multimodule.project.common.posts.data.sqldelight

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kmp.multimodule.project.common.core.database.DbDriverFactory
import kmp.multimodule.project.db.AppDatabase
import kmp.multimodule.project.db.AppDatabaseQueries
import kmp.multimodule.project.db.PostEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import models.Post
import kotlin.coroutines.CoroutineContext

internal class SqlDelightPostsDataSource(
    private val driverFactory: DbDriverFactory,
    private val coroutineContext: CoroutineContext,
) {

    private lateinit var queries: AppDatabaseQueries

    suspend fun fetchAllPosts(): Flow<List<PostEntity>> {
        return getQueries().selectAll().asFlow().mapToList(coroutineContext)
    }

    suspend fun createPost(post: Post) {
        getQueries().insert(title = post.title, description = post.description)
    }

    private suspend fun getQueries(): AppDatabaseQueries {
        if (this::queries.isInitialized.not()) {
            queries = AppDatabase.Companion(driverFactory.provideDbDriver(AppDatabase.Companion.Schema)).appDatabaseQueries
        }

        return queries
    }
}