package kmp.multimodule.project.common.auth.presentation.login

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kmp.multimodule.project.common.auth.presentation.login.LoginComponent.ViewState
import kmp.multimodule.project.common.core.presentation.utils.Consumer
import kmp.multimodule.project.common.core.presentation.utils.invoke
import kmp.multimodule.project.common.core.presentation.utils.tryToUpdate

internal class RealLoginComponent(
    componentContext: ComponentContext,
    private val onNavEvent: Consumer<LoginComponent.NavEvent>,
) : LoginComponent, ComponentContext by componentContext {
    override val viewState: Value<ViewState> = MutableValue(ViewState())

    override fun onEmailChanged(value: String) {
        viewState.tryToUpdate {
            it.copy(email = value)
        }
    }

    override fun onPasswordChanged(value: String) {
        viewState.tryToUpdate {
            it.copy(password = value)
        }
    }

    override fun onPasswordShowClick() {
        viewState.tryToUpdate {
            it.copy(isPasswordHidden = !it.isPasswordHidden)
        }
    }

    override fun onLoginClick() {
        onNavEvent(LoginComponent.NavEvent.Passed)
    }

    override fun onRegisterClick() {
        onNavEvent(LoginComponent.NavEvent.OpenRegister)
    }

    override fun onForgotClick() {
        onNavEvent(LoginComponent.NavEvent.OpenForgotPassword)
    }
}