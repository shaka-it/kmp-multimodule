package kmp.multimodule.project.features.post.models

import kotlinx.serialization.Serializable

@Serializable
data class FetchPostsRequest(
    val searchQuery: String
)