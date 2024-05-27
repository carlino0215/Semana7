package com.example.login_jetpack_compose.main

class MonedaRepository(
    private val api: MonedaApi
) {
    suspend fun getCharacters(): Result<List<MonedaCharacter>> {
        return try {
            val response = api.getCharacters().serie
            val characters = response.map { convert(it) }
            Result.success(characters)
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    private fun convert(serie: Serie) : MonedaCharacter{
        return MonedaCharacter(
            fecha = serie.fecha,
            valor = serie.valor)
    }
}