package kmp.multimodule.project.common.core.presentation.component

import org.koin.dsl.module

internal val componentModule = module {
    single<ComponentFactory>(createdAtStart = true) {
        ComponentFactory(getKoin())
    }
}