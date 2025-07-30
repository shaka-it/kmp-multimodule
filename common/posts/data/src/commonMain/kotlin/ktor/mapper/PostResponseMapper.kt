package ktor.mapper

import ktor.models.GameResponse
import models.Post

internal class PostResponseMapper {
    fun toGame(from: GameResponse): Post {
        return Post(
            id = from.id.orEmpty(),
            order = from.order ?: 0L,
            text = from.text.orEmpty(),
            isDone = from.isDone ?: false,
        )
    }
}