package repository

import models.Todo

interface TodosRepository {
    suspend fun fetchAllTodos(): List<Todo>
    suspend fun searchTodo(query: String): List<Todo>
}
