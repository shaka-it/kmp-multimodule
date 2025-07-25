package kmp.multimodule.project.common.auth.compose.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kmp.multimodule.project.common.auth.presentation.register.FakeRegisterComponent
import kmp.multimodule.project.common.auth.presentation.register.RegisterComponent
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.AppTheme
import theme.Theme

@Composable
fun RegisterScreen(component: RegisterComponent) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Register Screen",
            color = Theme.colors.primaryTextColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    AppTheme {
        RegisterScreen(FakeRegisterComponent())
    }
}
