package com.example.rickandmorty.presentation.Heroes

import com.example.rickandmorty.domain.model.HeroDataDetails

data class HeroesState(
    val heroesList: List<HeroDataDetails> = listOf()
)