package com.example.lessononerx

import android.content.Intent
import com.example.lessononerx.ui.ClubActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Main() = ActivityScreen { context -> ClubActivity.createLaunchIntent(context) }
    /*fun AddressSearch() = FragmentScreen { AddressSearchFragment() }
    fun Profile(userId: Long) = FragmentScreen("Profile_$userId") { ProfileFragment(userId) }
    fun Browser(url: String) = ActivityScreen { Intent(Intent.ACTION_VIEW, Uri.parse(url))  }*/
}