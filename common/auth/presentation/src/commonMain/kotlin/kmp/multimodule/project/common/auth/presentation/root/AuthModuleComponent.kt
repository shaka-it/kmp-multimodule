package kmp.multimodule.project.common.auth.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kmp.multimodule.project.common.auth.presentation.forgot.ForgotPasswordComponent
import kmp.multimodule.project.common.auth.presentation.login.LoginComponent
import kmp.multimodule.project.common.auth.presentation.register.RegisterComponent

interface AuthModuleComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface NavEvent {
        object Passed : NavEvent
    }

    sealed interface Child {
        class Login(val component: LoginComponent) : Child
        class Register(val component: RegisterComponent) : Child
        class ForgotPassword(val component: ForgotPasswordComponent) : Child
    }
}