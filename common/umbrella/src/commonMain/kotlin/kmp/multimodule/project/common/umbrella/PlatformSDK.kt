package kmp.multimodule.project.common.umbrella

import authModule
import kmp.multimodule.project.common.core.PlatformConfiguration
import kmp.multimodule.project.common.core.coreModule
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.module
import postsModule

object PlatformSDK {

    lateinit var koin: Koin private set

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

        koin = startKoin {
            modules(modules = modules)
        }.koin
    }
}