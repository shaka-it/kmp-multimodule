package kmp.multimodule.project.common.auth.presentation.forgot

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.auth.presentation.forgot.ForgotPasswordComponent.NavEvent
import kmp.multimodule.project.common.core.presentation.utils.Consumer

internal class RealForgotPasswordComponent(
    componentContext: ComponentContext,
    private val onNavEvent: Consumer<NavEvent>,
): ForgotPasswordComponent, ComponentContext by componentContext