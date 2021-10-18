package com.example.lessononerx.domain

interface UserStorage {
    fun saveUser(user: UserProfile)
    fun getUsers(): List<UserProfile>
}