package com.marshall.irvine.rickmorty.data.source

import com.marshall.irvine.rickmorty.data.model.CharacterResult
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface RickAndMortyAPIRoute {

    @GET("/character")
    fun getAllCharacters(): Flow<CharacterResult>
}