package kmp.multimodule.project.common.root

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.core.component.ComponentFactory
import org.koin.core.component.get

fun ComponentFactory.createRootComponent(componentContext: ComponentContext): RootComponent {
    return RealRootComponent(componentContext = componentContext, componentFactory = get())
}