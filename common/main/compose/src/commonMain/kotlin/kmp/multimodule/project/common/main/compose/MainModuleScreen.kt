package kmp.multimodule.project.common.main.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kmp.multimodule.project.common.main.presentation.root.FakeMainModuleComponent
import kmp.multimodule.project.common.main.presentation.root.MainModuleComponent
import org.jetbrains.compose.ui.tooling.preview.Preview
import kmp.multimodule.project.common.core.compose.theme.AppTheme
import kmp.multimodule.project.common.core.compose.theme.Theme
import kmp.multimodule.project.common.core.compose.theme.Theme.colors

@Composable
fun MainModuleScreen(
    component: MainModuleComponent,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.primaryBackground),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "This is the main screen",
            fontSize = 18.sp,
            color = colors.primaryTextColor,
        )
    }
}

@Preview
@Composable
private fun MainModuleScreenPreview() {
    AppTheme {
        MainModuleScreen(FakeMainModuleComponent())
    }
}
