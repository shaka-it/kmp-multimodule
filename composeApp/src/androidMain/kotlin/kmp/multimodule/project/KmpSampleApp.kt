package kmp.multimodule.project

import kmp.multimodule.project.common.core.PlatformConfiguration
import android.app.Application
import kmp.multimodule.project.common.umbrella.PlatformSDK

class KmpSampleApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun KmpSampleApp.initPlatformSDK() =
    PlatformSDK.init(configuration = PlatformConfiguration(androidContext = applicationContext))