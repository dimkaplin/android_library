package com.example.lessononerx

import android.app.Application
import com.example.lessononerx.ui.Router
import com.github.terrakok.cicerone.Cicerone

class App: Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    /*override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }*/
}