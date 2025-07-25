package ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GameResponse(
    @SerialName("id") val id: String? = null,
    @SerialName("order") val order: Long? = null,
    @SerialName("text") val text: String? = null,
    @SerialName("isDone") val isDone: Boolean? = null,
)