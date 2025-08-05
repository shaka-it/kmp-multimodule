package kmp.multimodule.project.features.post

import io.ktor.server.application.Application
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.configurePostRouting() {

    routing {
        post("/posts/create") {
            PostsController(call).createGame()
        }

        post("/posts/search") {
            PostsController(call).performSearch()
        }
    }
}