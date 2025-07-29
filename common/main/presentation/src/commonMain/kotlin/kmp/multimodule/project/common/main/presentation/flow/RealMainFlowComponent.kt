package kmp.multimodule.project.common.main.presentation.flow

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kmp.multimodule.project.common.core.presentation.component.ComponentFactory
import kmp.multimodule.project.common.core.presentation.utils.Consumer
import kmp.multimodule.project.common.core.presentation.utils.invoke
import kmp.multimodule.project.common.main.presentation.flow.MainFlowComponent.NavEvent
import kotlinx.serialization.Serializable

class RealMainFlowComponent(
    componentContext: ComponentContext,
    private val onNavEvent: Consumer<NavEvent>,
    private val componentFactory: ComponentFactory,
) : MainFlowComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Posts,
        handleBackButton = true,
        childFactory = ::createChild,
    )

    override val childStack: Value<ChildStack<*, MainFlowComponent.Child>> = stack

    override fun onPostsTabClicked() {
        navigation.bringToFront(Config.Posts)
    }

    override fun onCreatePostTabClicked() {
        navigation.bringToFront(Config.CreatePost)
    }

    override fun onProfilesTabClicked() {
        navigation.bringToFront(Config.Profile)
    }

    private fun createChild(
        config: Config,
        componentContext: ComponentContext,
    ): MainFlowComponent.Child =
        when (config) {
            Config.Posts -> MainFlowComponent.Child.Posts(
                componentFactory.createLoginComponent(
                    componentContext = componentContext,
                    onNavEvent = Consumer(::onLoginNavEvent),
                )
            )

            Config.CreatePost -> MainFlowComponent.Child.CreatePost(
                componentFactory.createRegisterComponent(
                    componentContext = componentContext,
                    onNavEvent = Consumer(::onRegisterNavEvent),
                )
            )

            Config.Profile -> MainFlowComponent.Child.Profile(
                componentFactory.createForgotPasswordComponent(
                    componentContext = componentContext,
                    onNavEvent = Consumer(::onForgotPasswordNavEvent),
                )
            )
        }

    private fun onProfileNavEvent(output: ProfileComponent.NavEvent): Unit =
        when (output) {
            is ProfileComponent.NavEvent.OpenAuthFlow -> onNavEvent(NavEvent.OpenAuthFlow)
        }

    @Serializable
    private sealed interface Config {
        @Serializable
        object Posts : Config

        @Serializable
        object CreatePost : Config

        @Serializable
        object Profile : Config
    }
}