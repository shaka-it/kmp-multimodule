package kmp.multimodule.project.common.posts.compose.make

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kmp.multimodule.project.common.core.compose.theme.AppTheme
import kmp.multimodule.project.common.core.compose.theme.Theme.colors
import kmp.multimodule.project.common.posts.presentation.make.FakeMakePostComponent
import kmp.multimodule.project.common.posts.presentation.make.MakePostComponent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MakePostScreen(
    component: MakePostComponent,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = colors.primaryBackground),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This is the make post screen",
            fontSize = 18.sp,
            color = colors.primaryTextColor,
        )
    }
}

@Preview
@Composable
private fun MakePostScreenPreview() {
    AppTheme {
        MakePostScreen(FakeMakePostComponent())
    }
}
