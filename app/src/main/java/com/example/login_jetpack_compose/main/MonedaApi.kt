package com.example.login_jetpack_compose.main

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface MonedaApi {
    companion object{
        val instance = Retrofit.Builder().baseUrl("https://mindicador.cl/api/")
            .addConverterFactory(MoshiConverterFactory.create()).client(
                OkHttpClient.Builder().build())
            .build().create(MonedaApi::class.java)
    }
    @GET("bitcoin")
    suspend fun getCharacters():CharactersResponse
}