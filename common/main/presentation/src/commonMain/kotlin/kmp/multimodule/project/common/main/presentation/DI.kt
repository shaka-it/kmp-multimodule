package kmp.multimodule.project.common.main.presentation

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.core.presentation.component.ComponentFactory
import kmp.multimodule.project.common.core.presentation.utils.Consumer
import kmp.multimodule.project.common.main.presentation.flow.MainFlowComponent
import kmp.multimodule.project.common.main.presentation.flow.MainFlowComponent.NavEvent
import kmp.multimodule.project.common.main.presentation.flow.RealMainFlowComponent

fun ComponentFactory.createMainModuleComponent(
    componentContext: ComponentContext,
    onNavEvent: Consumer<NavEvent>,
): MainFlowComponent {
    return RealMainFlowComponent(componentContext = componentContext, onNavEvent = onNavEvent)
}