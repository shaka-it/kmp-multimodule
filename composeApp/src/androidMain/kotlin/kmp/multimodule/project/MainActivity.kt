package kmp.multimodule.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import kmp.multimodule.project.common.core.compose.theme.AppTheme
import kmp.multimodule.project.common.core.di.Inject
import kmp.multimodule.project.common.core.presentation.component.ComponentFactory
import kmp.multimodule.project.common.root.RootScreen
import kmp.multimodule.project.common.root.createRootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val componentFactory = Inject.instance<ComponentFactory>()
        val rootComponent = componentFactory.createRootComponent(defaultComponentContext())

        setContent {
            AppTheme {
                RootScreen(component = rootComponent)
            }
        }
    }
}