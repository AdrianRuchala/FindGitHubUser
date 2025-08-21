package com.example.findgithubuser.presentation.userDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.findgithubuser.presentation.AppViewModel

@Composable
fun UserDetailsScreen(modifier: Modifier, viewModel: AppViewModel){
    val viewState = viewModel.viewState.value

}