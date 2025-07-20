package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import ktor.models.SearchTodoRequest
import ktor.models.TodoResponse

internal class KtorTodosDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllTodos(): List<TodoResponse> {
        return httpClient.post {
            header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")

            url {
                path("todos/search")
                setBody(SearchTodoRequest(searchQuery = ""))
            }
        }.body()
    }

    suspend fun searchTodo(query: String): List<TodoResponse> {
        return httpClient.post {
            header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")

            url {
                path("todos/search")
                setBody(SearchTodoRequest(searchQuery = query))
            }
        }.body()
    }
}