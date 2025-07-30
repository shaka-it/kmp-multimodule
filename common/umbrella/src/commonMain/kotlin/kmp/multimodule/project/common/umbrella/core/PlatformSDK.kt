package kmp.multimodule.project.common.umbrella.core

import kmp.multimodule.project.common.auth.data.authDataModule
import kmp.multimodule.project.common.core.PlatformConfiguration
import kmp.multimodule.project.common.core.coreModule
import kmp.multimodule.project.common.core.di.Inject
import kmp.multimodule.project.common.core.presentation.corePresentationModule
import kmp.multimodule.project.common.posts.data.postsDataModule
import kmp.multimodule.project.common.posts.presentation.postsPresentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

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
            corePresentationModule,
            postsDataModule,
            authDataModule,
            postsPresentationModule,
        )

        Inject.init(
            koin = startKoin {
                modules(modules = modules)
            }.koin,
        )
    }
}