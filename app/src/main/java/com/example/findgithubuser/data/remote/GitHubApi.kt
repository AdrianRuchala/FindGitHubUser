package com.example.findgithubuser.data.remote

import com.example.findgithubuser.domain.models.Repo
import com.example.findgithubuser.domain.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("users/{username}")
    suspend fun getUserData(@Path("username") username: String): User

    @GET("users/{username}/repos")
    suspend fun getUserRepos(@Path(value = "username") username: String): List<Repo>
}