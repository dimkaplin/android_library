package com.example.lessononerx.domain

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface UserProfileApi {
    @GET("users/{user}/repos")
    //fun listUsers(@Path("user") login: String): Call<List<UserProfile>>
    fun listUsers(@Path("user") login: String): Single<List<UserProfile>>
}