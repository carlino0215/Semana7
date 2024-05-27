package com.example.login_jetpack_compose.main


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Serie(
    @Json(name = "fecha")
    val fecha: String,
    @Json(name = "valor")
    val valor: Double
)