package kmp.multimodule.project

import PlatformConfiguration
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        PlatformSDK.init(
            configuration = PlatformConfiguration()
        )
        App()
    }
}