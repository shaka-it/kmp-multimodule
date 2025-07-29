package kmp.multimodule.project.common.root

import kmp.multimodule.project.common.auth.api.AuthRepository
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import kmp.multimodule.project.common.auth.presentation.createAuthModuleComponent
import kmp.multimodule.project.common.auth.presentation.flow.AuthFlowComponent
import kmp.multimodule.project.common.core.presentation.component.ComponentFactory
import kmp.multimodule.project.common.core.presentation.utils.Consumer
import kmp.multimodule.project.common.main.presentation.createMainModuleComponent
import kmp.multimodule.project.common.main.presentation.flow.MainFlowComponent
import kmp.multimodule.project.common.root.RootComponent.Child
import kotlinx.serialization.Serializable

class RealRootComponent(
    componentContext: ComponentContext,
    private val componentFactory: ComponentFactory,
    private val authRepository: AuthRepository,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, Child>> = childStack(
        source = navigation,
        initialConfiguration = getInitialConfig(),
        handleBackButton = true,
        childFactory = ::createChild,
        serializer = Config.serializer(),
    )

    private fun getInitialConfig(): Config {
        return if (authRepository.isUserLoggedIn()) {
            Config.Main
        } else {
            Config.Auth
        }
    }

    private fun createChild(
        config: Config,
        componentContext: ComponentContext,
    ): Child =
        when (config) {
            Config.Auth -> Child.AuthModule(
                componentFactory.createAuthModuleComponent(
                    componentContext = componentContext,
                    onNavEvent = Consumer(::onAuthNavEvent),
                )
            )

            Config.Main -> Child.MainModule(
                componentFactory.createMainModuleComponent(
                    componentContext = componentContext,
                    onNavEvent = Consumer(::onMainNavEvent),
                )
            )
        }

    private fun onAuthNavEvent(output: AuthFlowComponent.NavEvent): Unit =
        when (output) {
            is AuthFlowComponent.NavEvent.OpenMainFlow -> navigation.pushNew(Config.Main)
        }

    private fun onMainNavEvent(output: MainFlowComponent.NavEvent): Unit =
        when (output) {
            is MainFlowComponent.NavEvent.OpenAuthFlow -> navigation.pushNew(Config.Auth)
        }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Auth : Config

        @Serializable
        data object Main : Config
    }
}