package ktor.mapper

import ktor.models.TodoResponse
import models.Todo

internal class TodoResponseMapper {
    fun toTodo(from: TodoResponse): Todo {
        return Todo(
            id = from.id.orEmpty(),
            order = from.order ?: 0L,
            text = from.text.orEmpty(),
            isDone = from.isDone ?: false,
        )
    }
}