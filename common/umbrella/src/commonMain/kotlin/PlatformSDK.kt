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
            todosModule,
        )

        startKoin {
            modules(modules = modules)
        }
    }
}