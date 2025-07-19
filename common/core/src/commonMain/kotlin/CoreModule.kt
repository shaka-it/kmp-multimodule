import database.databaseModule
import json.serializationModule
import ktor.ktorModule
import org.koin.dsl.module

internal val coreModule = module {
    includes(ktorModule, serializationModule, databaseModule)
}