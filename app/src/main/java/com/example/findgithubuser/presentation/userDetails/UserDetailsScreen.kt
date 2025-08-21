package com.example.findgithubuser.presentation.userDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.findgithubuser.R
import com.example.findgithubuser.presentation.AppViewModel
import com.example.findgithubuser.presentation.AppViewState
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun UserDetailsScreen(modifier: Modifier, viewModel: AppViewModel, onNavigateUp: () -> Unit) {
    val viewState = viewModel.viewState.value

    Column(
        modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier
                    .size(24.dp)
                    .clickable { onNavigateUp() }
            )

            Text(stringResource(R.string.user_profile))

            Spacer(modifier.size(24.dp))
        }

        HorizontalDivider(modifier.padding(8.dp))

        UserDetails(modifier, viewState)
    }
}

@Composable
fun UserDetails(modifier: Modifier, viewState: AppViewState) {
    var userAvatar by remember { mutableStateOf("") }
    var userLogin by remember { mutableStateOf("") }
    var userId by remember { mutableStateOf("") }
    var userType by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var userCompany by remember { mutableStateOf("") }
    var userLocation by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var userHireable by remember { mutableStateOf("") }

    userAvatar = viewState.user?.avatar_url.toString()
    userLogin = viewState.user?.login.toString()
    userId = viewState.user?.id.toString()
    userType = viewState.user?.type.toString()
    userName = viewState.user?.name.toString()
    userCompany = viewState.user?.company.toString()
    userLocation = viewState.user?.location.toString()
    userEmail = viewState.user?.email.toString()
    userHireable = viewState.user?.hireable.toString()

    Column(
        modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            imageModel = { userAvatar },
            modifier
                .size(144.dp)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colorScheme.secondaryContainer, CircleShape)
        )

        Text(
            userLogin,
            style = MaterialTheme.typography.headlineLarge,
            modifier = modifier.padding(8.dp)
        )

        HorizontalDivider(modifier.padding(8.dp))

        Row(
            modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 48.dp)
                .border(4.dp, MaterialTheme.colorScheme.primary, CircleShape)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(horizontal = 12.dp)
                .clickable { },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.git_repo),
                contentDescription = null,
                modifier.size(24.dp)
            )

            Text(
                stringResource(R.string.check_repos),
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(16.dp)
            )
        }
    }
}