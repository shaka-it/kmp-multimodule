package kmp.multimodule.project.common.auth.presentation.register

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.auth.presentation.register.RegisterComponent.NavEvent
import kmp.multimodule.project.common.core.utils.Consumer

internal class RealRegisterComponent(
    componentContext: ComponentContext,
    private val onNavEvent: Consumer<NavEvent>,
): RegisterComponent, ComponentContext by componentContext