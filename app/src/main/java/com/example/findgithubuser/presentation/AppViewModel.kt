package com.example.findgithubuser.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findgithubuser.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    var viewState = mutableStateOf(AppViewState())

    private fun getUserData(username: String) {
        viewModelScope.launch {
            try {
                val user = repository.getUserData(username)
                if (user != null) {
                    viewState.value = viewState.value.copy(user)
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun isUserExisting(username: String, onSuccess: (String) -> Unit, onError: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val user = repository.getUserData(username)
                if (user != null) {
                    onError(false)
                    getUserData(username)
                    onSuccess(username)
                } else {
                    onError(true)
                }
            } catch (e: Exception) {
                onError(true)
            }
        }

    }
}
