package kmp.multimodule.project.common.main.presentation.flow

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface MainFlowComponent {

    val childStack: Value<ChildStack<*, Child>>

    fun onPostsTabClicked()
    fun onCreatePostTabClicked()
    fun onProfilesTabClicked()

    sealed interface NavEvent {
        data object OpenAuthFlow : NavEvent
    }

    sealed class Child {
        class Posts(val component: PostsComponent) : Child()
        class CreatePost(val component: CreatePostComponent) : Child()
        class Profile(val component: ProfileComponent) : Child()
    }
}