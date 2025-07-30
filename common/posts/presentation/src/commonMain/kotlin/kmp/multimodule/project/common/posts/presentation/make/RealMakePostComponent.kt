package kmp.multimodule.project.common.posts.presentation.make

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kmp.multimodule.project.common.core.presentation.utils.tryToUpdate
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import models.Post
import repository.PostsRepository
import kotlin.coroutines.CoroutineContext

class RealMakePostComponent(
    componentContext: ComponentContext,
    mainContext: CoroutineContext,
    private val postsRepository: PostsRepository,
) : MakePostComponent, ComponentContext by componentContext {
    private val scope = coroutineScope(mainContext + SupervisorJob())

    override val viewState: Value<MakePostComponent.ViewState> =
        MutableValue(MakePostComponent.ViewState())

    override fun onTitleChanged(value: String) {
        viewState.tryToUpdate {
            it.copy(title = value)
        }
    }

    override fun onDescriptionChanged(value: String) {
        viewState.tryToUpdate {
            it.copy(description = value)
        }
    }

    override fun onMakePostClick() {
        val title = viewState.value.title
        val description = viewState.value.description
        if (title.isEmpty() || description.isEmpty()) return

        scope.launch {
            postsRepository.createPost(
                post = Post(
                    title = title,
                    description = description,
                )
            )
            viewState.tryToUpdate {
                it.copy(
                    title = "",
                    description = "",
                )
            }
        }
    }
}