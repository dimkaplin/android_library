package com.example.lessononerx

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.lessononerx.domain.ContextHolder
import com.example.lessononerx.domain.EventBus
import com.example.lessononerx.domain.UserProfileApi
import com.example.lessononerx.ui.Router
import com.github.terrakok.cicerone.Cicerone
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class App: Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val eventBus = EventBus()

    private val okClient = OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor()
        .apply { HttpLoggingInterceptor.Level.BODY })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(okClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
    val serviceUsers: UserProfileApi = retrofit.create(UserProfileApi::class.java)


    override fun onCreate() {
        super.onCreate()
        //INSTANCE = this
        initDependencies()
    }

    /*companion object {
        internal lateinit var INSTANCE: App
            private set
    }*/



    private fun initDependencies(){
        ContextHolder.setContext(this)
    }
}

val Fragment.app : App
    get() = requireContext().applicationContext as App

val Activity.app : App
get() = applicationContext as App

val Context.app : App
    get() = this as App