package com.example.rickandmorty.presentation.Heroes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.repository.RepositoryHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModel @Inject constructor(private val repository: RepositoryHero) : ViewModel() {
    private val _state = mutableStateOf(HeroesState())
    val state: State<HeroesState> = _state

    init {
        processEvent(event = Event.getHeroes)
    }
    fun processEvent(event: Event) {
        when (event) {
            is Event.getHeroes -> getHeroes()
        }
    }


    private fun getHeroes() {
        viewModelScope.launch {
            val heroes = repository.getHeroes()
            _state.value = _state.value.copy(heroesList = heroes)
        }
    }
}