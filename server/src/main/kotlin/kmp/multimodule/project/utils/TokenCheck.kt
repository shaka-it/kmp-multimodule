package kmp.multimodule.project.utils

import kmp.multimodule.project.database.tokens.Tokens

object TokenCheck {

    fun isTokenValid(token: String): Boolean =
        Tokens.fetchTokens().firstOrNull { it.token == token } != null
}