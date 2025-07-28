package kmp.multimodule.project

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import kmp.multimodule.project.common.core.PlatformConfiguration
import kmp.multimodule.project.common.core.component.ComponentFactory
import kmp.multimodule.project.common.core.di.Inject
import kmp.multimodule.project.common.root.RootScreen
import kmp.multimodule.project.common.root.createRootComponent
import kmp.multimodule.project.common.umbrella.core.PlatformSDK
import theme.AppTheme

fun MainViewController() = ComposeUIViewController {
    PlatformSDK.init(configuration = PlatformConfiguration())

    val componentContext = DefaultComponentContext(lifecycle = ApplicationLifecycle())
    val componentFactory = Inject.instance<ComponentFactory>()
    val rootComponent = componentFactory.createRootComponent(componentContext)

    AppTheme {
        RootScreen(component = rootComponent)
    }
}