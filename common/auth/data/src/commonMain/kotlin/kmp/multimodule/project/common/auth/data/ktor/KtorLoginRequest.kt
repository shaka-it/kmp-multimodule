package kmp.multimodule.project.common.auth.data.ktor

import kotlinx.serialization.Serializable

@Serializable
data class KtorLoginRequest(
    val login: String,
    val password: String
)
