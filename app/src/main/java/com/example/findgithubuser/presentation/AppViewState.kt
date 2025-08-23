package com.example.findgithubuser.presentation

import com.example.findgithubuser.domain.models.Repo
import com.example.findgithubuser.domain.models.User

data class AppViewState (
    val user: User? = null,
    val repos: List<Repo>? = null
)