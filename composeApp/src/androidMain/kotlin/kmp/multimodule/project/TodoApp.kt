package kmp.multimodule.project

import PlatformConfiguration
import android.app.Application

class TodoApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun TodoApp.initPlatformSDK() =
    PlatformSDK.init(configuration = PlatformConfiguration(androidContext = applicationContext))