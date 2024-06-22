package com.example.rickandmorty.presentation.HeroesDetail

import com.example.rickandmorty.domain.model.HeroDataDetails

data class DetailState(
    val heroesDetail: HeroDataDetails = HeroDataDetails(
        name = "",
        gender = "",
        id = 1
    )
)