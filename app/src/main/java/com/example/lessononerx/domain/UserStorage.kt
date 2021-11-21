package com.example.lessononerx.domain

import io.reactivex.Observable
//import retrofit2.Call

interface UserStorage {
    val users: Observable<List<UserProfile>>
    fun saveUser(user: UserProfile)
    fun getUsers(): List<UserProfile>

   // fun listUsers(user: UserProfile) Call<List<Repo>>
}