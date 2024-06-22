package com.example.rickandmorty.presentation.HeroesDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.repository.RepositoryHero
import com.example.rickandmorty.presentation.Heroes.Event
import com.example.rickandmorty.presentation.Heroes.HeroesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelDetail @Inject constructor(
    private val repository: RepositoryHero,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(DetailState())
    val heroesState: State<DetailState> = _state

    init{
        val id = savedStateHandle.get<Int>("id")
        processEvent(event = DetailEvent.GetHero(id = id!!))
    }
    fun processEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.GetHero -> getHero(event.id)
        }
    }


    private fun getHero(id: Int) {
        viewModelScope.launch {
            val heroDetail = repository.getHeroes()
            //_state.value = _state.value.copy(heroesDetail = )
        }
    }
}