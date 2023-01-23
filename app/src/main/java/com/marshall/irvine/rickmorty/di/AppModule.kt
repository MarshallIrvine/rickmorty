package com.marshall.irvine.rickmorty.di

import com.marshall.irvine.rickmorty.data.repository.CharacterRepositoryImpl
import com.marshall.irvine.rickmorty.data.source.RMAPIRouteService
import com.marshall.irvine.rickmorty.domain.character.useCase.GetAllCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRMAPIRouteService(): RMAPIRouteService {
        return RMAPIRouteService.getInstance()
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(apiService: RMAPIRouteService): CharacterRepositoryImpl {
        return CharacterRepositoryImpl(apiService = apiService)
    }
    @Provides
    @Singleton
    fun provideGetAllCharactersUseCase(characterRepositoryImpl: CharacterRepositoryImpl): GetAllCharactersUseCase {
        return GetAllCharactersUseCase(characterRepositoryImpl)
    }
}