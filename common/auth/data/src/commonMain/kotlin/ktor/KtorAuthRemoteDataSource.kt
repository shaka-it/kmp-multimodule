package ktor

import io.ktor.client.HttpClient
import kmp.multimodule.project.common.auth.api.models.Token

class KtorAuthRemoteDataSource(
    private val httpClient: HttpClient,
) {

    suspend fun performLogin(request: KtorLoginRequest): Token {
//        return httpClient.post {
//            url {
//                path("login")
//                setBody(request)
//            }
//        }.body()
        return Token(token = "token")
    }
}