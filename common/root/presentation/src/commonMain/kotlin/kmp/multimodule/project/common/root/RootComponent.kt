package kmp.multimodule.project.common.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kmp.multimodule.project.common.auth.presentation.root.AuthModuleComponent
import kmp.multimodule.project.common.main.presentation.root.MainModuleComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class AuthModule(val component: AuthModuleComponent) : Child
        class MainModule(val component: MainModuleComponent) : Child
    }
}