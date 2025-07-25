package kmp.multimodule.project.common.auth.presentation.forgot

import kmp.multimodule.project.common.auth.presentation.register.RegisterComponent.NavEvent

interface ForgotPasswordComponent {
    sealed interface NavEvent {
        data object Finished : NavEvent
    }
}