package kmp.multimodule.project.common.auth.presentation.root

import kmp.multimodule.project.common.auth.presentation.login.FakeLoginComponent
import kmp.multimodule.project.common.core.utils.createFakeChildStackValue

class FakeAuthModuleComponent : AuthModuleComponent {
    override val childStack = createFakeChildStackValue(
        AuthModuleComponent.Child.Login(FakeLoginComponent())
    )
}
