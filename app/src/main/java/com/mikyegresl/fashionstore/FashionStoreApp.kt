package com.mikyegresl.fashionstore

import android.app.Application
import com.mikyegresl.fashionstore.di.featureHomeModule
import com.mikyegresl.fashionstore.di.networkModule
import com.mikyegresl.fashionstore.di.repositoryModule
import com.mikyegresl.fashionstore.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import java.util.concurrent.atomic.AtomicBoolean

class FashionStoreApp: Application() {

    private val isInit = AtomicBoolean(false)
    private val isInitialized: Boolean get() =
        isInit.get()

    private lateinit var fashionStoreApp: KoinApplication

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        if (isInitialized) {
            clear()
        }
        if (!isInitialized) {
            fashionStoreApp = startKoin {
                androidContext(this@FashionStoreApp)
                modules(
                    networkModule,
                    storageModule,
                    repositoryModule,
                    featureHomeModule
                )
            }
            isInit.set(true)
        }
    }

    private fun clear() {
        fashionStoreApp.close()
        isInit.set(false)
    }
}