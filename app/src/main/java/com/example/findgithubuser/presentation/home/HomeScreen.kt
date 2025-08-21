package com.example.findgithubuser.presentation.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.findgithubuser.R
import com.example.findgithubuser.presentation.AppViewModel

@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: AppViewModel,
    navigateToUserDetails: (String) -> Unit
) {
    var searchValue by remember { mutableStateOf("") }
    val error = remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (error.value) {
        if (searchValue.isEmpty()) {
            Toast.makeText(context, stringResource(R.string.user_name_is_null), Toast.LENGTH_LONG)
                .show()
        }
        Toast.makeText(context, stringResource(R.string.user_not_found), Toast.LENGTH_LONG).show()
    }

    Column(
        modifier
            .fillMaxSize()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            stringResource(R.string.home_screen_text),
            style = MaterialTheme.typography.headlineLarge
        )

        TextField(
            value = searchValue,
            onValueChange = { searchValue = it },
            placeholder = { Text(stringResource(R.string.search_user)) },
            isError = error.value,
            shape = MaterialTheme.shapes.medium,
            modifier = modifier.padding(top = 16.dp)
        )

        Button(onClick = {
            viewModel.isUserExisting(
                searchValue,
                { navigateToUserDetails(searchValue) },
                { isError -> error.value = isError })
        }) {
            Text(stringResource(R.string.search))
        }

        if (isSystemInDarkTheme()) {
            Image(
                painter = painterResource(R.drawable.github_logo_white),
                contentDescription = null,
                modifier.size(240.dp)
            )
        } else {
            Image(
                painter = painterResource(R.drawable.github_logo),
                contentDescription = null,
                modifier.size(240.dp)
            )
        }
    }
}
