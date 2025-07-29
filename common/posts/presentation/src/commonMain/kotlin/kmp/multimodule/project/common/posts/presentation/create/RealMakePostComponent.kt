package kmp.multimodule.project.common.posts.presentation.create

import com.arkivanov.decompose.ComponentContext

class RealMakePostComponent(
    componentContext: ComponentContext,
) : MakePostComponent, ComponentContext by componentContext