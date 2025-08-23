package com.example.findgithubuser.data.repository

import com.example.findgithubuser.data.remote.GitHubApi
import com.example.findgithubuser.domain.models.Repo
import com.example.findgithubuser.domain.models.User
import com.example.findgithubuser.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val api: GitHubApi
): AppRepository {
    override suspend fun getUserData(username: String): User {
        return api.getUserData(username)
    }

    override suspend fun getUserRepos(username: String): List<Repo> {
        return api.getUserRepos(username)
    }
}