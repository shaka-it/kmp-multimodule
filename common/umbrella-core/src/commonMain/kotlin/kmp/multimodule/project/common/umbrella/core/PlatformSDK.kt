package kmp.multimodule.project.common.umbrella.core

import authModule
import kmp.multimodule.project.common.core.PlatformConfiguration
import kmp.multimodule.project.common.core.coreModule
import kmp.multimodule.project.common.core.di.Inject
import org.koin.core.context.startKoin
import org.koin.dsl.module
import postsModule

object PlatformSDK {
    fun init(
        configuration: PlatformConfiguration
    ) {
        val umbrellaModule = module {
            single {
                configuration
            }
        }
        val modules = listOf(
            umbrellaModule,
            coreModule,
            postsModule,
            authModule,
        )

        Inject.init(
            koin = startKoin {
                modules(modules = modules)
            }.koin,
        )
    }
}