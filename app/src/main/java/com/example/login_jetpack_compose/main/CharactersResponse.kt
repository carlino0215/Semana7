package com.example.login_jetpack_compose.main


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersResponse(
    @Json(name = "autor")
    val autor: String,
    @Json(name = "codigo")
    val codigo: String,
    @Json(name = "nombre")
    val nombre: String,
    @Json(name = "serie")
    val serie: List<Serie>,
    @Json(name = "unidad_medida")
    val unidadMedida: String,
    @Json(name = "version")
    val version: String
)