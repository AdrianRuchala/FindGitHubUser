package com.example.findgithubuser.domain.models

data class Repo (
    val id: Int,
    val name: String,
    val full_name: String,
    val owner: User,
    val private: Boolean,
    val html_url: String,
    val description: String?,
    val fork: Boolean,
    val url: String,
    val stargazers_count: Int,
    val watchers_count: Int,
    val language: String?,
    val forks_count: Int,
    val open_issues_count: Int
)
