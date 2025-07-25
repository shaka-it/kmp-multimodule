package kmp.multimodule.project

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import kmp.multimodule.project.common.core.PlatformConfiguration
import kmp.multimodule.project.common.core.component.ComponentFactory
import kmp.multimodule.project.common.root.RootScreen
import kmp.multimodule.project.common.root.createRootComponent
import kmp.multimodule.project.common.umbrella.PlatformSDK
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        PlatformSDK.init(
            configuration = PlatformConfiguration()
        )

        val lifecycle = LifecycleRegistry()
        val componentContext = DefaultComponentContext(lifecycle = lifecycle)
        val componentFactory = PlatformSDK.koin.get<ComponentFactory>()
        val rootComponent = componentFactory.createRootComponent(componentContext)

        RootScreen(component = rootComponent)
    }
}