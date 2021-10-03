package com.example.lessononerx.domain

import com.example.lessononerx.domain.City
import java.util.*

data class UserPfile(
    val FIO: String,
    val age: Int,
    val DateBirth: Date,
    val weight: Int,
    val city: City,
    val photo: String
)
