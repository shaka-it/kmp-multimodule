package kmp.multimodule.project.common.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import kmp.multimodule.project.common.auth.presentation.createAuthModuleComponent
import kmp.multimodule.project.common.auth.presentation.root.AuthModuleComponent
import kmp.multimodule.project.common.core.presentation.component.ComponentFactory
import kmp.multimodule.project.common.core.presentation.utils.Consumer
import kmp.multimodule.project.common.main.presentation.createMainModuleComponent
import kmp.multimodule.project.common.main.presentation.root.MainModuleComponent
import kmp.multimodule.project.common.root.RootComponent.Child
import kotlinx.serialization.Serializable

class RealRootComponent(
    componentContext: ComponentContext,
    private val componentFactory: ComponentFactory,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, Child>> = childStack(
        source = navigation,
        initialConfiguration = Config.Auth,
        handleBackButton = true,
        childFactory = ::createChild,
        serializer = Config.serializer(),
    )

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

    private fun onAuthNavEvent(output: AuthModuleComponent.NavEvent): Unit =
        when (output) {
            is AuthModuleComponent.NavEvent.Passed -> navigation.pushNew(Config.Main)
        }

    private fun onMainNavEvent(output: MainModuleComponent.NavEvent): Unit =
        when (output) {
            is MainModuleComponent.NavEvent.Finished -> navigation.pop()
        }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Auth : Config

        @Serializable
        data object Main : Config
    }
}