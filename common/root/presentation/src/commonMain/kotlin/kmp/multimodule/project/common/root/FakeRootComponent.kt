package kmp.multimodule.project.common.root

import kmp.multimodule.project.common.core.presentation.utils.createFakeChildStackValue
import kmp.multimodule.project.common.main.presentation.flow.FakeMainFlowComponent

class FakeRootComponent : RootComponent {
    override val childStack = createFakeChildStackValue(
        RootComponent.Child.MainModule(FakeMainFlowComponent())
    )
}
