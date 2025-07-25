package ktor.models

import kotlinx.serialization.Serializable

@Serializable
internal data class SearchGameRequest(
    val searchQuery: String,
)