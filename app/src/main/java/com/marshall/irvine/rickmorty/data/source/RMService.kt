package com.marshall.irvine.rickmorty.data.source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RMService {

    private const val BASE_URL = "https://rickandmortyapi.com/api"

    @Volatile
    var INSTANCE: RickAndMortyAPIRoute? = null

    fun getInstance(): RickAndMortyAPIRoute {
        return INSTANCE ?: synchronized(this) {
            val instance = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RickAndMortyAPIRoute::class.java)
            INSTANCE = instance
            instance
        }
    }
}

