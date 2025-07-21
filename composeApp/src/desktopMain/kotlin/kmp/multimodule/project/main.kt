package kmp.multimodule.project

import PlatformConfiguration
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    PlatformSDK.init(
        configuration = PlatformConfiguration()
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "kmp-multimodule-project",
    ) {
        App()
    }
}