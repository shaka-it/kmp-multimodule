package kmp.multimodule.project.common.auth.presentation.login

import com.arkivanov.decompose.value.Value

interface LoginComponent {
    val viewState: Value<ViewState>

    fun onEmailChanged(value: String)
    fun onPasswordChanged(value: String)
    fun onPasswordShowClick()
    fun onLoginClick()
    fun onRegisterClick()
    fun onForgotClick()

    data class ViewState(
        val email: String = "",
        val password: String = "",
        val isSending: Boolean = false,
        val isPasswordHidden: Boolean = true
    )

    sealed interface NavEvent {
        object OpenMainFlow : NavEvent

        object OpenRegister : NavEvent

        object OpenForgotPassword : NavEvent
    }
}