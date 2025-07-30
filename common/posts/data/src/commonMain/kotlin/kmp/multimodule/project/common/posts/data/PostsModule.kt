package kmp.multimodule.project.common.posts.data

import kmp.multimodule.project.common.posts.data.mapper.PostEntityMapper
import kmp.multimodule.project.common.posts.data.repository.DefaultPostsRepository
import kmp.multimodule.project.common.posts.data.sqldelight.SqlDelightPostsDataSource
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import repository.PostsRepository

val postsDataModule = module {
    factory {
        PostEntityMapper()
    }
    single {
        SqlDelightPostsDataSource(
            driverFactory = get(),
            coroutineContext = Dispatchers.Default,
        )
    }
    single<PostsRepository> {
        DefaultPostsRepository(
            localDataSource = get(),
            postEntityMapper = get(),
            coroutineContext = Dispatchers.Default,
        )
    }
}