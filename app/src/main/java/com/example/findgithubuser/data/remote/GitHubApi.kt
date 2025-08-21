package com.example.findgithubuser.data.remote

import com.example.findgithubuser.domain.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("users/{username}")
    suspend fun getUserData(@Path("username") username: String): User
}