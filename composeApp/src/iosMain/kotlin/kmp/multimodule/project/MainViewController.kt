package kmp.multimodule.project

import PlatformConfiguration
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    PlatformSDK.init(configuration = PlatformConfiguration())
    App()
}