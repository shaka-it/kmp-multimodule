package kmp.multimodule.project.common.core

import kmp.multimodule.project.common.core.component.componentModule
import kmp.multimodule.project.common.core.database.databaseModule
import kmp.multimodule.project.common.core.json.serializationModule
import kmp.multimodule.project.common.core.ktor.ktorModule
import kmp.multimodule.project.common.core.settings.settingsModule
import org.koin.dsl.module

val coreModule = module {
    includes(
        ktorModule,
        serializationModule,
        databaseModule,
        settingsModule,
        componentModule,
    )
}