package com.example.rickandmorty.presentation.HeroesDetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HeroesDetailScreen(
    state: DetailState,
    processEvent: (DetailEvent) -> Unit
) {

    Text(text = state.heroesDetail.name)
    Text(text = state.heroesDetail.gender)

}