package kmp.multimodule.project.common.auth.data.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import kmp.multimodule.project.common.auth.api.models.Token

class KtorAuthRemoteDataSource(
    private val httpClient: HttpClient,
) {

    suspend fun performLogin(request: KtorLoginRequest): Token {
        return httpClient.post {
            url {
                path("login")
                setBody(request)
            }
        }.body()
    }
}