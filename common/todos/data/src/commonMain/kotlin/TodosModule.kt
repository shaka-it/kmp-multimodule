import ktor.KtorTodosDataSource
import ktor.mapper.TodoResponseMapper
import org.koin.dsl.module
import repository.DefaultTodosRepository
import repository.TodosRepository
import sqldelight.SqlDelightTodosDataSource

val todosModule = module {
    single {
        KtorTodosDataSource(httpClient = get())
    }
    factory {
        TodoResponseMapper()
    }
    single {
        SqlDelightTodosDataSource()
    }
    single<TodosRepository> {
        DefaultTodosRepository(
            remoteDataSource = get(),
            localDataSource = get(),
            todoResponseMapper = get(),
        )
    }
}