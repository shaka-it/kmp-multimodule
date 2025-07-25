package kmp.multimodule.project.common.auth.compose.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp.multimodule.project.common.auth.presentation.login.FakeLoginComponent
import kmp.multimodule.project.common.auth.presentation.login.LoginComponent
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.AppTheme
import theme.Theme

@Composable
fun LoginScreen(component: LoginComponent) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Login Screen",
            color = Theme.colors.primaryTextColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Theme.colors.primaryAction,
            ),
            enabled = true,
            shape = RoundedCornerShape(10.dp),
            onClick = component::onLoginClick,
        ) {
            Text(
                text = "Login",
                color = Theme.colors.primaryTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Theme.colors.primaryAction,
            ),
            enabled = true,
            shape = RoundedCornerShape(10.dp),
            onClick = component::onForgotClick,
        ) {
            Text(
                text = "Forgot",
                color = Theme.colors.primaryTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Theme.colors.primaryAction,
            ),
            enabled = true,
            shape = RoundedCornerShape(10.dp),
            onClick = component::onRegisterClick,
        ) {
            Text(
                text = "Register",
                color = Theme.colors.primaryTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    AppTheme {
        LoginScreen(FakeLoginComponent())
    }
}
