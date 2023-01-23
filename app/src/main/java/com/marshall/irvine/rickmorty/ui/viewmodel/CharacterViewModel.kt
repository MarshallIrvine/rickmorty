package com.marshall.irvine.rickmorty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marshall.irvine.rickmorty.domain.character.useCase.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.marshall.irvine.rickmorty.data.model.Character
import kotlinx.coroutines.launch

@HiltViewModel
class CharacterViewModel
@Inject constructor(private val useCase: GetAllCharactersUseCase) :
    ViewModel() {
    private var _characters = MutableLiveData<List<Character>>()
    val characters get() = _characters

    fun fetchCharacters() {
        viewModelScope.launch {
            useCase.invoke().collect {
                _characters.postValue(it.results)
            }
        }
    }

}