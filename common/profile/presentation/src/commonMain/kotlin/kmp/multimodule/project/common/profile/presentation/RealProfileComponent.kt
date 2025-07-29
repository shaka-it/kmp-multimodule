package kmp.multimodule.project.common.profile.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kmp.multimodule.project.common.core.presentation.utils.Consumer
import kmp.multimodule.project.common.core.presentation.utils.invoke
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class RealProfileComponent(
    componentContext: ComponentContext,
    mainContext: CoroutineContext,
    private val onNavEvent: Consumer<ProfileComponent.NavEvent>,
) : ProfileComponent, ComponentContext by componentContext {

    override val viewState: Value<ProfileComponent.ViewState> =
        MutableValue(ProfileComponent.ViewState())

    private val scope = coroutineScope(mainContext + SupervisorJob())

    override fun onLogoutClicked() {
        onNavEvent(ProfileComponent.NavEvent.OpenAuthFlow)
    }
}