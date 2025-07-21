import ktor.KtorAuthRemoteDataSource
import org.koin.dsl.module
import settings.SettingsAuthDataSource

val authModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(
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