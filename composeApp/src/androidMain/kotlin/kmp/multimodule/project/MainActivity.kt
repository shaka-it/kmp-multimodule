package kmp.multimodule.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import kmp.multimodule.project.common.core.component.ComponentFactory
import kmp.multimodule.project.common.root.RootScreen
import kmp.multimodule.project.common.root.createRootComponent
import kmp.multimodule.project.common.umbrella.PlatformSDK
import theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val componentFactory = PlatformSDK.koin.get<ComponentFactory>()
        val rootComponent = componentFactory.createRootComponent(defaultComponentContext())

        setContent {
            AppTheme {
                RootScreen(component = rootComponent)
            }
        }
    }
}