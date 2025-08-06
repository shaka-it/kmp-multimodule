package kmp.multimodule.project.features.post

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import kmp.multimodule.project.database.posts.Posts
import kmp.multimodule.project.database.posts.mapToCreatePostResponse
import kmp.multimodule.project.database.posts.mapToPostDto
import kmp.multimodule.project.database.tokens.Tokens
import kmp.multimodule.project.features.post.models.CreatePostRequest
import kmp.multimodule.project.utils.TokenCheck

class PostsController(private val call: ApplicationCall) {

    suspend fun fetchPosts() {
        val token = call.request.headers["Bearer-Authorization"]

        if (TokenCheck.isTokenValid(token.orEmpty())) {
            call.respond(Posts.fetchAll())
        } else {
            call.respond(HttpStatusCode.Unauthorized, "Token expired")
        }
    }

    suspend fun createPost() {
        val token = call.request.headers["Bearer-Authorization"]
        if (TokenCheck.isTokenValid(token.orEmpty())) {
            val request = call.receive<CreatePostRequest>()
            val post = request.mapToPostDto(
                author = Tokens.fetchTokenDtoByToken(tokenValue = token.orEmpty())?.login.orEmpty(),
            )
            Posts.insert(post)
            call.respond(post.mapToCreatePostResponse())
        } else {
            call.respond(HttpStatusCode.Unauthorized, "Token expired")
        }
    }
}