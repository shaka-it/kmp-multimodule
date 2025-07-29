package kmp.multimodule.project.common.profile.presentation

import com.arkivanov.decompose.ComponentContext
import kmp.multimodule.project.common.core.presentation.component.ComponentFactory
import kmp.multimodule.project.common.core.presentation.utils.Consumer
import kotlinx.coroutines.Dispatchers

fun ComponentFactory.createProfileComponent(
    componentContext: ComponentContext,
    onNavEvent: Consumer<ProfileComponent.NavEvent>,
): ProfileComponent {
    return RealProfileComponent(
        componentContext = componentContext,
        mainContext = Dispatchers.Main.immediate,
        onNavEvent = onNavEvent,
    )
}