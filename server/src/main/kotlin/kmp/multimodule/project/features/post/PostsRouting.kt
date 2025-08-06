package kmp.multimodule.project.features.post

import io.ktor.server.application.Application
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.configurePostsRouting() {

    routing {
        post("/posts/create") {
            PostsController(call).createGame()
        }

        get("/posts/search") {
            PostsController(call).performSearch()
        }
    }
}