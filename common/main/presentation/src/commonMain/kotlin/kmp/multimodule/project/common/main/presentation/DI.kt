package kmp.multimodule.project.common.main.presentation

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.core.component.ComponentFactory
import kmp.multimodule.project.common.core.utils.Consumer
import kmp.multimodule.project.common.main.presentation.root.MainModuleComponent
import kmp.multimodule.project.common.main.presentation.root.MainModuleComponent.NavEvent
import kmp.multimodule.project.common.main.presentation.root.RealMainModuleComponent

fun ComponentFactory.createMainModuleComponent(
    componentContext: ComponentContext,
    onNavEvent: Consumer<NavEvent>,
): MainModuleComponent {
    return RealMainModuleComponent(componentContext = componentContext, onNavEvent = onNavEvent)
}