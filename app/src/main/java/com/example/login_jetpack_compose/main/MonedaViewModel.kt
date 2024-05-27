package com.example.login_jetpack_compose.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MonedaViewModel(
    private  val repository:MonedaRepository = MonedaRepository(MonedaApi.instance)
) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set
    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.getCharacters().onSuccess {
                state = state.copy(
                    characters = it
                )
            }.onFailure {
                println()
            }
            state = state.copy(isLoading = false)
        }
    }
}