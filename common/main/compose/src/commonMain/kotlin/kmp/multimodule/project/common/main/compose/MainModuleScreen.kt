package kmp.multimodule.project.common.main.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kmp.multimodule.project.common.main.presentation.root.FakeMainModuleComponent
import kmp.multimodule.project.common.main.presentation.root.MainModuleComponent
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.AppTheme
import theme.Theme

@Composable
fun MainModuleScreen(component: MainModuleComponent) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Main Module Screen",
            color = Theme.colors.primaryTextColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
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
