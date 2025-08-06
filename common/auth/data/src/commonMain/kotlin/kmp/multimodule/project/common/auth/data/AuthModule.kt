package kmp.multimodule.project.common.auth.data

import kmp.multimodule.project.common.auth.api.AuthRepository
import kmp.multimodule.project.common.auth.data.ktor.KtorAuthRemoteDataSource
import kmp.multimodule.project.common.auth.data.settings.SettingsAuthDataSource
import org.koin.dsl.module

val authDataModule = module {
    single<AuthRepository> {
        DefaultAuthRepository(
            remoteDataSource = get(),
            cacheDataSource = get(),
        )
    }

    factory {
        SettingsAuthDataSource(settings = get())
    }

    factory {
        KtorAuthRemoteDataSource(httpClient = get())
    }
}