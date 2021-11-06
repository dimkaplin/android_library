package com.example.lessononerx.impl.utils

import android.content.Context
import com.example.lessononerx.App

val Context.app: App
     get() {
         return applicationContext as App
     }