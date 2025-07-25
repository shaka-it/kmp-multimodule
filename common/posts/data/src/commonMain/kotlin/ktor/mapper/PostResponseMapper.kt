package ktor.mapper

import ktor.models.GameResponse
import models.Game

internal class PostResponseMapper {
    fun toGame(from: GameResponse): Game {
        return Game(
            id = from.id.orEmpty(),
            order = from.order ?: 0L,
            text = from.text.orEmpty(),
            isDone = from.isDone ?: false,
        )
    }
}