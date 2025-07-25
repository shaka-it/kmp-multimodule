package kmp.multimodule.project.common.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import kmp.multimodule.project.common.auth.compose.root.AuthModuleScreen
import kmp.multimodule.project.common.main.compose.MainModuleScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.AppTheme

@Composable
fun RootScreen(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    val childStack by component.childStack.subscribeAsState()

    Children(childStack, modifier) { child ->
        when (val instance = child.instance) {
            is RootComponent.Child.AuthModule -> AuthModuleScreen(instance.component)
            is RootComponent.Child.MainModule -> MainModuleScreen(instance.component)
        }
    }
}

@Preview
@Composable
private fun RootScreenPreview() {
    AppTheme {
        RootScreen(FakeRootComponent())
    }
}
