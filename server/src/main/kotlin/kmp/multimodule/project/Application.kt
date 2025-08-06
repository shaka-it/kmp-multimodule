package kmp.multimodule.project

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kmp.multimodule.project.features.login.configureLoginRouting
import kmp.multimodule.project.features.post.configurePostsRouting
import kmp.multimodule.project.plugins.configureDatabase
import kmp.multimodule.project.plugins.configureRouting
import kmp.multimodule.project.plugins.configureSerialization

fun main() {
    embeddedServer(
        factory = Netty,
        port = SERVER_PORT,
        module = Application::module,
    ).start(wait = true)
}

fun Application.module() {
    configureDatabase()
    configureRouting()
    configureLoginRouting()
    configurePostsRouting()
    configureSerialization()
}