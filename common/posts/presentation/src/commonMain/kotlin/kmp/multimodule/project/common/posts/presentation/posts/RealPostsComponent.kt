package kmp.multimodule.project.common.posts.presentation.posts

import com.arkivanov.decompose.ComponentContext

class RealPostsComponent(
    componentContext: ComponentContext,
) : PostsComponent, ComponentContext by componentContext