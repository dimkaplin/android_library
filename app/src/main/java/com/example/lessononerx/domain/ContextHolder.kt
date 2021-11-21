package com.example.lessononerx.domain

import android.annotation.SuppressLint
import android.content.Context
import com.example.lessononerx.App

@SuppressLint("StaticFieldLeak")
object ContextHolder {
    private lateinit var context: Context

    fun getContext(): Context {
      return context
    }

    fun setContext(context: Context) {
       this.context = context
    }

    fun getApp(): App {
        return context.applicationContext as App
    }
}