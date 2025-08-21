package com.example.findgithubuser

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.findgithubuser.navigation.AppNavHost
import com.example.findgithubuser.presentation.AppViewModel

@Composable
fun MainScreen(
    modifier: Modifier,
    navHostController: NavHostController,
    viewModel: AppViewModel
) {
    Scaffold { paddingValues ->
        AppNavHost(
            modifier.padding(paddingValues),
            navHostController,
            viewModel
        )
    }
}