package kmp.multimodule.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import kmp.multimodule.project.common.core.PlatformConfiguration
import kmp.multimodule.project.common.core.component.ComponentFactory
import kmp.multimodule.project.common.root.RootScreen
import kmp.multimodule.project.common.root.createRootComponent
import kmp.multimodule.project.common.umbrella.PlatformSDK
import theme.AppTheme

fun main() = application {
    PlatformSDK.init(
        configuration = PlatformConfiguration()
    )

    val lifecycle = LifecycleRegistry()
    val componentContext = DefaultComponentContext(lifecycle = lifecycle)
    val componentFactory = PlatformSDK.koin.get<ComponentFactory>()
    val rootComponent = componentFactory.createRootComponent(componentContext)

    Window(
        onCloseRequest = ::exitApplication,
        title = "kmp-multimodule-project",
    ) {
        AppTheme {
            RootScreen(component = rootComponent)
        }
    }
}