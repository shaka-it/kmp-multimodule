package kmp.multimodule.project.common.main.presentation.root

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.core.utils.Consumer
import kmp.multimodule.project.common.main.presentation.root.MainModuleComponent.NavEvent

class RealMainModuleComponent(
    componentContext: ComponentContext,
    private val onNavEvent: Consumer<NavEvent>,
): MainModuleComponent