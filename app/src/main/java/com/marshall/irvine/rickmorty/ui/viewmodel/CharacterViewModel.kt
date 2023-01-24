package com.marshall.irvine.rickmorty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marshall.irvine.rickmorty.domain.character.useCase.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.marshall.irvine.rickmorty.data.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CharacterViewModel
@Inject constructor(private val useCase: GetAllCharactersUseCase) :
    ViewModel() {

    private val _charactersList = MutableStateFlow(listOf<Character>())
    var charactersList = _charactersList.asStateFlow()

    fun fetchCharacters() {
        viewModelScope.launch {
            useCase.invoke().collect {
                _charactersList.value = it.results
            }
        }
    }

}