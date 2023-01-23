package com.marshall.irvine.rickmorty.data.repository

import com.marshall.irvine.rickmorty.data.model.CharacterResult
import com.marshall.irvine.rickmorty.data.source.RMAPIRouteService
import com.marshall.irvine.rickmorty.domain.character.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val apiService: RMAPIRouteService): CharacterRepository {
    override fun getAllCharacter(): Flow<CharacterResult> = flow { emit(apiService.getAllCharacters().body()!!) }
}