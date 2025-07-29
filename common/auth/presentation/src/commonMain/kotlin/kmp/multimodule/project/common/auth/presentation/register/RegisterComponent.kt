package kmp.multimodule.project.common.auth.presentation.register

interface RegisterComponent {

    fun onBackClick()

    sealed interface NavEvent {
        object Back : NavEvent
    }
}