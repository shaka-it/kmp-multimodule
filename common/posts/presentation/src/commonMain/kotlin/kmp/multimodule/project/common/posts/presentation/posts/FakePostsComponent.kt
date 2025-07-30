package kmp.multimodule.project.common.posts.presentation.posts

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class FakePostsComponent : PostsComponent {
    override val viewState: Value<PostsComponent.ViewState>
        get() = MutableValue(PostsComponent.ViewState())
}