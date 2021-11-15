package com.example.lessononerx

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.lessononerx.domain.EventBus
import com.example.lessononerx.ui.Router
import com.github.terrakok.cicerone.Cicerone

class App: Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val eventBus = EventBus()

    /*override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }*/
}

val Fragment.app : App
    get() = requireContext().applicationContext as App

val Activity.app : App
get() = applicationContext as App

val Context.app : App
    get() = this as App