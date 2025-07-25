package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import ktor.models.SearchGameRequest
import ktor.models.GameResponse

internal class KtorPostsDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllPosts(): List<GameResponse> {
        return httpClient.post {
            header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")

            url {
                path("posts/search")
                setBody(SearchGameRequest(searchQuery = ""))
            }
        }.body()
    }

    suspend fun searchPost(query: String): List<GameResponse> {
        return httpClient.post {
            header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")

            url {
                path("posts/search")
                setBody(SearchGameRequest(searchQuery = query))
            }
        }.body()
    }
}