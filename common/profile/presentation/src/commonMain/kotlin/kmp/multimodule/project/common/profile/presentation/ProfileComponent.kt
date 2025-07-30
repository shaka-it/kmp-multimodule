package kmp.multimodule.project.common.profile.presentation

import com.arkivanov.decompose.value.Value

interface ProfileComponent {
    val viewState: Value<ViewState>

    fun onLogoutClicked()

    data class ViewState(
        val name: String = "",
        val surname: String = "",
        val imageUrl: String = "",
    )

    sealed interface NavEvent {
        data object OpenAuthFlow : NavEvent
    }
}