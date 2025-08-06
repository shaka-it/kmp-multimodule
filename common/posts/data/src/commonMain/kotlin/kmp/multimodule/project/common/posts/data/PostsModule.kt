package kmp.multimodule.project.common.posts.data

import kmp.multimodule.project.common.posts.api.repository.PostsRepository
import kmp.multimodule.project.common.posts.data.ktor.KtorPostsDataSource
import kmp.multimodule.project.common.posts.data.mapper.PostMapper
import kmp.multimodule.project.common.posts.data.repository.DefaultPostsRepository
import kmp.multimodule.project.common.posts.data.sqldelight.SqlDelightPostsDataSource
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val postsDataModule = module {
    factory {
        PostMapper()
    }
    single {
        SqlDelightPostsDataSource(
            driverFactory = get(),
            coroutineContext = Dispatchers.Default,
        )
    }
    single {
        KtorPostsDataSource(
            httpClient = get(),
            authRepository = get(),
        )
    }
    single<PostsRepository> {
        DefaultPostsRepository(
            localDataSource = get(),
            postMapper = get(),
            remoteDataSource = get(),
            coroutineContext = Dispatchers.Default,
        )
    }
}