package kmp.multimodule.project.common.posts.compose.posts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import kmp.multimodule.project.common.core.compose.theme.AppTheme
import kmp.multimodule.project.common.core.compose.theme.Theme.colors
import kmp.multimodule.project.common.posts.presentation.posts.FakePostsComponent
import kmp.multimodule.project.common.posts.presentation.posts.PostsComponent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PostsScreen(
    component: PostsComponent,
    modifier: Modifier = Modifier
) {
    val state by component.viewState.subscribeAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(colors.primaryBackground)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(state.posts) { post ->
            PostItem(
                title = post.title,
                description = post.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
private fun PostItem(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 18.sp,
            color = colors.primaryTextColor
        )
        Text(
            text = description,
            fontSize = 14.sp,
            color = colors.secondaryTextColor,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview
@Composable
private fun MakePostsScreenPreview() {
    AppTheme {
        PostsScreen(FakePostsComponent())
    }
}
