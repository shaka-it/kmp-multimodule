package kmp.multimodule.project.common.core.presentation

import kmp.multimodule.project.common.core.presentation.component.componentModule
import org.koin.dsl.module

val corePresentationModule = module {
    includes(
        componentModule,
    )
}