package repository

import ktor.KtorTodosDataSource
import ktor.mapper.TodoResponseMapper
import models.Todo
import sqldelight.SqlDelightTodosDataSource

internal class DefaultTodosRepository(
    private val remoteDataSource: KtorTodosDataSource,
    private val localDataSource: SqlDelightTodosDataSource,
    private val todoResponseMapper: TodoResponseMapper,
) : TodosRepository {
    override suspend fun fetchAllTodos(): List<Todo> {
        return remoteDataSource.fetchAllTodos().map(todoResponseMapper::toTodo)
    }

    override suspend fun searchTodo(query: String): List<Todo> {
        return remoteDataSource.searchTodo(query).map(todoResponseMapper::toTodo)
    }
}