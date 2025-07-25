package kmp.multimodule.project.common.auth.presentation.login

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class FakeLoginComponent : LoginComponent {
    override val viewState: Value<LoginComponent.ViewState>
        get() = MutableValue(LoginComponent.ViewState())

    override fun onEmailChanged(value: String) = Unit

    override fun onPasswordChanged(value: String) = Unit

    override fun onPasswordShowClick() = Unit

    override fun onLoginClick() = Unit

    override fun onRegisterClick() = Unit

    override fun onForgotClick() = Unit
}
