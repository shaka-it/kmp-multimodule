package kmp.multimodule.project.common.posts.presentation.posts

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kmp.multimodule.project.common.core.presentation.utils.tryToUpdate
import kmp.multimodule.project.common.posts.presentation.mapper.PostDvoMapper
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import repository.PostsRepository
import kotlin.coroutines.CoroutineContext

class RealPostsComponent(
    componentContext: ComponentContext,
    mainContext: CoroutineContext,
    private val postsRepository: PostsRepository,
    private val postDvoMapper: PostDvoMapper,
) : PostsComponent, ComponentContext by componentContext {
    private val scope = coroutineScope(mainContext + SupervisorJob())

    override val viewState: Value<PostsComponent.ViewState> =
        MutableValue(PostsComponent.ViewState())

    init {
        getPosts()
    }

    fun getPosts() {
        scope.launch {
            postsRepository.fetchAllPosts()
                .map {
                    it.map(postDvoMapper::toPostDvo)
                }
                .collect { postList ->
                    viewState.tryToUpdate {
                        it.copy(posts = postList)
                    }
                }
        }
    }
}