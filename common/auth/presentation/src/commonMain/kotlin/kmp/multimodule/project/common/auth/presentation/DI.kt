package kmp.multimodule.project.common.auth.presentation

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.auth.presentation.forgot.ForgotPasswordComponent
import kmp.multimodule.project.common.auth.presentation.forgot.RealForgotPasswordComponent
import kmp.multimodule.project.common.auth.presentation.login.LoginComponent
import kmp.multimodule.project.common.auth.presentation.login.RealLoginComponent
import kmp.multimodule.project.common.auth.presentation.register.RealRegisterComponent
import kmp.multimodule.project.common.auth.presentation.register.RegisterComponent
import kmp.multimodule.project.common.auth.presentation.root.AuthModuleComponent
import kmp.multimodule.project.common.auth.presentation.root.RealAuthModuleComponent
import kmp.multimodule.project.common.core.component.ComponentFactory
import kmp.multimodule.project.common.core.utils.Consumer
import org.koin.core.component.get

fun ComponentFactory.createAuthModuleComponent(
    componentContext: ComponentContext,
    onNavEvent: Consumer<AuthModuleComponent.NavEvent>,
): AuthModuleComponent {
    return RealAuthModuleComponent(
        componentContext = componentContext,
        onNavEvent = onNavEvent,
        componentFactory = get(),
    )
}

fun ComponentFactory.createLoginComponent(
    componentContext: ComponentContext,
    onNavEvent: Consumer<LoginComponent.NavEvent>,
): LoginComponent {
    return RealLoginComponent(
        componentContext = componentContext,
        onNavEvent = onNavEvent,
    )
}

fun ComponentFactory.createRegisterComponent(
    componentContext: ComponentContext,
    onNavEvent: Consumer<RegisterComponent.NavEvent>,
): RegisterComponent {
    return RealRegisterComponent(
        componentContext = componentContext,
        onNavEvent = onNavEvent,
    )
}

fun ComponentFactory.createForgotPasswordComponent(
    componentContext: ComponentContext,
    onNavEvent: Consumer<ForgotPasswordComponent.NavEvent>,
): ForgotPasswordComponent {
    return RealForgotPasswordComponent(
        componentContext = componentContext,
        onNavEvent = onNavEvent,
    )
}