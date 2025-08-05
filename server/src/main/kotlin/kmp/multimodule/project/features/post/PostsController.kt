package kmp.multimodule.project.features.post

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import kmp.multimodule.project.database.posts.Posts
import kmp.multimodule.project.database.posts.mapToCreatePostResponse
import kmp.multimodule.project.database.posts.mapToPostDto
import kmp.multimodule.project.features.post.models.CreatePostRequest
import kmp.multimodule.project.features.post.models.FetchPostsRequest
import kmp.multimodule.project.utils.TokenCheck

class PostsController(private val call: ApplicationCall) {

    suspend fun performSearch() {
        val request = call.receive<FetchPostsRequest>()
        val token = call.request.headers["Bearer-Authorization"]

        if (TokenCheck.isTokenValid(token.orEmpty())) {
            if (request.searchQuery.isBlank()) {
                call.respond(Posts.fetchAll())
            } else {
                call.respond(
                    Posts.fetchAll()
                        .filter { it.title.contains(request.searchQuery, ignoreCase = true) })
            }
        } else {
            call.respond(HttpStatusCode.Unauthorized, "Token expired")
        }
    }

    suspend fun createGame() {
        val token = call.request.headers["Bearer-Authorization"]
        if (TokenCheck.isTokenValid(token.orEmpty())) {
            val request = call.receive<CreatePostRequest>()
            val game = request.mapToPostDto()
            Posts.insert(game)
            call.respond(game.mapToCreatePostResponse())
        } else {
            call.respond(HttpStatusCode.Unauthorized, "Token expired")
        }
    }
}