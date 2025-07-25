import ktor.KtorPostsDataSource
import ktor.mapper.PostResponseMapper
import org.koin.dsl.module
import repository.DefaultPostsRepository
import repository.PostsRepository
import sqldelight.SqlDelightPostsDataSource

val postsModule = module {
    single {
        KtorPostsDataSource(httpClient = get())
    }
    factory {
        PostResponseMapper()
    }
    single {
        SqlDelightPostsDataSource()
    }
    single<PostsRepository> {
        DefaultPostsRepository(
            remoteDataSource = get(),
            localDataSource = get(),
            postResponseMapper = get(),
        )
    }
}