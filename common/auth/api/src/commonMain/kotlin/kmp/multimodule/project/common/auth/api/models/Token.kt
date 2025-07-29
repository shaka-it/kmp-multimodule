package kmp.multimodule.project.common.auth.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val token: String
)