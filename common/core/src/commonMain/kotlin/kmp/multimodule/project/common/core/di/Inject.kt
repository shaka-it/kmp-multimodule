package kmp.multimodule.project.common.core.di

import org.koin.core.Koin

object Inject {
    private var _koin: Koin? = null
    val koin: Koin get() = requireNotNull(_koin)

    fun init(koin: Koin) {
        _koin = koin
    }

    inline fun <reified T> instance(): T = koin.get()
}
