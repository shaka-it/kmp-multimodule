package kmp.multimodule.project.common.auth.presentation.flow

import kmp.multimodule.project.common.auth.presentation.login.FakeLoginComponent
import kmp.multimodule.project.common.core.presentation.utils.createFakeChildStackValue

class FakeAuthFlowComponent : AuthFlowComponent {
    override val childStack = createFakeChildStackValue(
        AuthFlowComponent.Child.Login(FakeLoginComponent())
    )
}
