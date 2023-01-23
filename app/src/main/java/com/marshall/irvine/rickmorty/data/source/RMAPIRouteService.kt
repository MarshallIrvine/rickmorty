package com.marshall.irvine.rickmorty.data.source

import com.marshall.irvine.rickmorty.data.model.CharacterResult
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RMAPIRouteService {

    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterResult>
    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/api/"

        @Volatile
        private var INSTANCE: RMAPIRouteService? = null

        fun getInstance(): RMAPIRouteService {
            return INSTANCE ?: synchronized(this) {
                val instance = Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RMAPIRouteService::class.java)
                INSTANCE = instance
                instance
            }
        }
    }
}