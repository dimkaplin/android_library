package com.example.lessononerx.domain

import io.reactivex.Observable

interface UserStorage {
    val users: Observable<List<UserProfile>>
    fun saveUser(user: UserProfile)
    fun getUsers(): List<UserProfile>
}