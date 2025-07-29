package kmp.multimodule.project.common.main.presentation.flow

import kmp.multimodule.project.common.core.presentation.utils.createFakeChildStackValue

class FakeMainFlowComponent : MainFlowComponent {
    override val childStack = createFakeChildStackValue(
        MainFlowComponent.Child.Posts(FakePostsComponent())
    )
}
