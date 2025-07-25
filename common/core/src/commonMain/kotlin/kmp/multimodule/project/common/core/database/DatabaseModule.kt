package kmp.multimodule.project.common.core.database

import org.koin.dsl.module

internal val databaseModule = module {
    single {
        DbDriverFactory(platformConfiguration = get())
    }
}