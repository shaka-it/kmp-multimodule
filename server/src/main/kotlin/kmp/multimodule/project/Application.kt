package kmp.multimodule.project

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kmp.multimodule.project.features.login.configureLoginRouting
import kmp.multimodule.project.features.post.configurePostRouting
import kmp.multimodule.project.plugins.configureRouting
import kmp.multimodule.project.plugins.configureSerialization
import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect(
        url = System.getenv("DATABASE_CONNECTION_STRING"),
        driver = "org.postgresql.Driver",
        user = System.getenv("POSTGRES_USER"),
        password = System.getenv("POSTGRES_PASSWORD"),
    )

    embeddedServer(
        factory = Netty,
        port = System.getenv("SERVER_PORT").toInt(),
        module = Application::module,
    ).start(wait = true)
}

fun Application.module() {
    configureRouting()
    configureLoginRouting()
    configurePostRouting()
    configureSerialization()
}