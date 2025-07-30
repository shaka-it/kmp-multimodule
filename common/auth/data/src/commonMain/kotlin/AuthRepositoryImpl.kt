import kmp.multimodule.project.common.auth.api.AuthRepository
import kmp.multimodule.project.common.auth.api.models.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val cacheDataSource: SettingsAuthDataSource,
) : AuthRepository {

    override suspend fun login(login: String, password: String): Token =
        withContext(Dispatchers.Default) {
            val token = remoteDataSource.performLogin(
                request = KtorLoginRequest(
                    login = login,
                    password = password
                )
            )

            cacheDataSource.saveToken(token.token)
            token
        }

    override fun isUserLoggedIn(): Boolean {
        return cacheDataSource.fetchToken().isNotBlank()
    }

    override fun logout() {
        cacheDataSource.saveToken("")
    }
}