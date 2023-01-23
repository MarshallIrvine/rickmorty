package com.marshall.irvine.rickmorty.domain.character.useCase

import com.marshall.irvine.rickmorty.data.model.CharacterResult
import com.marshall.irvine.rickmorty.data.repository.CharacterRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val characterRepository: CharacterRepositoryImpl) {
    fun invoke(): Flow<CharacterResult> = characterRepository.getAllCharacter()
}