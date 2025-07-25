package kmp.multimodule.project.common.main.presentation.root

interface MainModuleComponent {
    sealed interface NavEvent {
        data object Finished : NavEvent
    }
}