package kmp.multimodule.project.common.main.presentation.flow

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kmp.multimodule.project.common.posts.presentation.create.MakePostComponent
import kmp.multimodule.project.common.posts.presentation.posts.PostsComponent
import kmp.multimodule.project.common.profile.presentation.ProfileComponent

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
        class MakePost(val component: MakePostComponent) : Child()
        class Profile(val component: ProfileComponent) : Child()
    }
}