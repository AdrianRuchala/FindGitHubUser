package com.example.findgithubuser.navigation

interface AppDestinations {
    val route: String
}

object Home : AppDestinations {
    override val route = "home"
}

object UserDetails: AppDestinations {
    override val route = "user_details"
}