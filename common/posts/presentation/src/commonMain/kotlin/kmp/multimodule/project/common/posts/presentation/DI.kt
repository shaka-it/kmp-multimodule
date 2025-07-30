package kmp.multimodule.project.common.posts.presentation

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.core.presentation.component.ComponentFactory
import kmp.multimodule.project.common.posts.presentation.make.MakePostComponent
import kmp.multimodule.project.common.posts.presentation.make.RealMakePostComponent
import kmp.multimodule.project.common.posts.presentation.mapper.PostDvoMapper
import kmp.multimodule.project.common.posts.presentation.posts.PostsComponent
import kmp.multimodule.project.common.posts.presentation.posts.RealPostsComponent
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.get
import org.koin.dsl.module

val postsPresentationModule = module {
    factory {
        PostDvoMapper()
    }
}

fun ComponentFactory.createPostsComponent(
    componentContext: ComponentContext,
): PostsComponent {
    return RealPostsComponent(
        componentContext = componentContext,
        mainContext = Dispatchers.Main.immediate,
        postsRepository = get(),
        postDvoMapper = get(),
    )
}

fun ComponentFactory.createMakePostComponent(
    componentContext: ComponentContext,
): MakePostComponent {
    return RealMakePostComponent(
        componentContext = componentContext,
        mainContext = Dispatchers.Main.immediate,
        postsRepository = get(),
    )
}