package com.example.findgithubuser.domain.repository

import com.example.findgithubuser.domain.models.User

interface AppRepository {
    suspend fun getUserData(username: String): User
}