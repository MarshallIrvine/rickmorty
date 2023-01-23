package com.marshall.irvine.rickmorty.domain.character.repository

import kotlinx.coroutines.flow.Flow
import com.marshall.irvine.rickmorty.data.model.CharacterResult

interface CharacterRepository {
    fun getAllCharacter(): Flow<CharacterResult>
}