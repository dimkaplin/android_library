package com.example.lessononerx.domain

import com.example.lessononerx.domain.City
import java.util.*

data class UserProfile(
    val FIO: String,
    val age: Int? = 0,
    val weight: Int? = 0,
    val city: City,
    val photo: String,
    val login: String,
    val password: String,
    val email: String,
    val id: String? = ""
)
