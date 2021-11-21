package com.example.lessononerx.domain

import com.example.lessononerx.domain.City
import com.squareup.moshi.Json
import java.util.*

data class UserProfile(
    @Json(name = "fio")
    val FIO: String,
    val age: Int? = 0,
    val weight: Int? = 0,
    val city: City,
    val photo: String,
    @Json(name="login")
    val login: String,
    @Json(name = "password")
    val password: String,
    @Json(name = "mail")
    val email: String,
    val id: String? = ""
)
