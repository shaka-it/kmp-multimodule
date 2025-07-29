package kmp.multimodule.project.common.auth.presentation.forgot

interface ForgotPasswordComponent {

    fun onBackClick()

    sealed interface NavEvent {
        data object Back : NavEvent
    }
}