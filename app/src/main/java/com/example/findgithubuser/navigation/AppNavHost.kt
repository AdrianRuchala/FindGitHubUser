package com.example.findgithubuser.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.findgithubuser.presentation.AppViewModel
import com.example.findgithubuser.presentation.home.HomeScreen
import com.example.findgithubuser.presentation.userDetails.UserDetailsScreen
import com.example.findgithubuser.presentation.userRepos.UserReposScreen

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: AppViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier.padding()
    ) {
        composable(Home.route) {
            HomeScreen(modifier, viewModel) { navController.navigateSingleTopTo(UserDetails.route) }
        }

        composable(UserDetails.route) {
            UserDetailsScreen(
                Modifier,
                viewModel,
                { navController.navigateSingleTopTo(UserRepos.route) },
                { navController.navigateUp() })
        }

        composable(UserRepos.route) {
            UserReposScreen(
                Modifier,
                viewModel
            ) { navController.navigateSingleTopTo(UserDetails.route) }
        }
    }
}

fun NavController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }