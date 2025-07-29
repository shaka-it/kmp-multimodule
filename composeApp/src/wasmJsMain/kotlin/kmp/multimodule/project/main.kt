package kmp.multimodule.project

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import kmp.multimodule.project.common.core.PlatformConfiguration
import kmp.multimodule.project.common.core.presentation.component.ComponentFactory
import kmp.multimodule.project.common.core.di.Inject
import kmp.multimodule.project.common.root.RootScreen
import kmp.multimodule.project.common.root.createRootComponent
import kmp.multimodule.project.common.umbrella.core.PlatformSDK
import kotlinx.browser.document
import kmp.multimodule.project.common.core.compose.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        PlatformSDK.init(
            configuration = PlatformConfiguration()
        )

        val lifecycle = LifecycleRegistry()
        val componentContext = DefaultComponentContext(lifecycle = lifecycle)
        val componentFactory = Inject.instance<ComponentFactory>()
        val rootComponent = componentFactory.createRootComponent(componentContext)

        AppTheme {
            RootScreen(component = rootComponent)
        }
    }
}