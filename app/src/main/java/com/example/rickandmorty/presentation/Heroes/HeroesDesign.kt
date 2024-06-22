package com.example.rickandmorty.presentation.Heroes

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rickandmorty.domain.model.HeroDataDetails
@SuppressLint("UnrememberedMutableState")
@Composable
fun HeroesScreen(
    state: HeroesState,
    processEvent: (Event) -> Unit,
    onHeroDetailScreenClick: (hero: HeroDataDetails) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HeroesCard(
            heroes = state.heroesList,
            onHeroDetailScreenClick = onHeroDetailScreenClick
        )
    }
}

@Composable
fun HeroesCard(
    heroes: List<HeroDataDetails>,
    onHeroDetailScreenClick: (heroes: HeroDataDetails) -> Unit
) {

    LazyColumn {
        items(heroes){ hero ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onHeroDetailScreenClick(hero)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "id:${hero.id}")
                    Text(text = "name: ${hero.name}")
                    Text(text = "gender: ${hero.gender}")
                }
            }
        }
    }
}