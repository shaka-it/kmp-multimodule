package kmp.multimodule.project.common.posts.presentation

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.core.presentation.component.ComponentFactory
import kmp.multimodule.project.common.posts.presentation.create.MakePostComponent
import kmp.multimodule.project.common.posts.presentation.create.RealMakePostComponent
import kmp.multimodule.project.common.posts.presentation.posts.PostsComponent
import kmp.multimodule.project.common.posts.presentation.posts.RealPostsComponent

fun ComponentFactory.createPostsComponent(
    componentContext: ComponentContext,
): PostsComponent {
    return RealPostsComponent(
        componentContext = componentContext,
    )
}

fun ComponentFactory.createMakePostComponent(
    componentContext: ComponentContext,
): MakePostComponent {
    return RealMakePostComponent(
        componentContext = componentContext,
    )
}