package com.example.rickandmorty.presentation.HeroesDetail

sealed class DetailEvent {
    data class GetHero(val id: Int) : DetailEvent()
}