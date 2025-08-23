package com.example.findgithubuser.presentation.userRepos

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.findgithubuser.R
import com.example.findgithubuser.domain.models.Repo
import com.example.findgithubuser.presentation.AppViewModel

@Composable
fun UserReposScreen(modifier: Modifier, viewModel: AppViewModel, onNavigateUp: () -> Unit) {
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

            Text(stringResource(R.string.user_repos))

            Spacer(modifier.size(24.dp))
        }

        HorizontalDivider(modifier.padding(8.dp))

        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(viewModel.viewState.value.repos ?: emptyList()) { repo ->
                RepoPlate(modifier, repo)
            }
        }
    }
}

@Composable
fun RepoPlate(modifier: Modifier, repo: Repo) {
    var showDetails by remember { mutableStateOf(false) }

    Column(
        modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .border(
                2.dp,
                MaterialTheme.colorScheme.secondary,
                MaterialTheme.shapes.medium
            )
            .clickable { showDetails = !showDetails },
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                repo.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(4.dp)
            )

            if (showDetails) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    modifier = modifier.padding(4.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = modifier.padding(4.dp)
                )
            }
        }

        if (showDetails) {
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    stringResource(R.string.user_id),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
                Text(
                    repo.id.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
            }

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    stringResource(R.string.repo_language),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
                Text(
                    repo.language.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
            }

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    stringResource(R.string.repo_owner),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
                Text(
                    repo.owner.login.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
            }

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    stringResource(R.string.repo_private),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
                Text(
                    repo.private.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
            }

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    stringResource(R.string.repo_fork),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
                Text(
                    repo.fork.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
            }

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    stringResource(R.string.repo_forks_count),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
                Text(
                    repo.forks_count.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
            }

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    stringResource(R.string.repo_stargazers_count),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
                Text(
                    repo.stargazers_count.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
            }

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    stringResource(R.string.repo_watchers_count),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
                Text(
                    repo.watchers_count.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
            }

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    stringResource(R.string.repo_open_issues_count),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(horizontal = 4.dp)
                )
                Text(
                    repo.open_issues_count.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(4.dp)
                )
            }
        }
    }
}
