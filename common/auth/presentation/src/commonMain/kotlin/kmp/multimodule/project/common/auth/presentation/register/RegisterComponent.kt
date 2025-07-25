package kmp.multimodule.project.common.auth.presentation.register

interface RegisterComponent {
    sealed interface NavEvent {
        object Passed : NavEvent
    }
}