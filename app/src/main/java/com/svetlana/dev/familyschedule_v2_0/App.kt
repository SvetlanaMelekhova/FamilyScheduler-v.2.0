package com.svetlana.dev.familyschedule_v2_0

import android.app.Application
import com.svetlana.dev.familyschedule_v2_0.di.AppComponent
import com.svetlana.dev.familyschedule_v2_0.di.DaggerAppComponent

class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}