package com.example.login_jetpack_compose.main

data class MainState(val isLoading: Boolean = false,
                     val characters: List<MonedaCharacter> = emptyList())