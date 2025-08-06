package kmp.multimodule.project.plugins

import kmp.multimodule.project.POSTGRES_PASSWORD
import kmp.multimodule.project.POSTGRES_URL
import kmp.multimodule.project.POSTGRES_USER
import org.jetbrains.exposed.sql.Database

fun configureDatabase() {
    Database.connect(
        url = POSTGRES_URL,
        driver = "org.postgresql.Driver",
        user = POSTGRES_USER,
        password = POSTGRES_PASSWORD,
    )
}