package com.example.rickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rickandmorty.presentation.Heroes.HeroesScreen
import com.example.rickandmorty.presentation.Heroes.ViewModel
import com.example.rickandmorty.presentation.HeroesDetail.HeroesDetailScreen
import com.example.rickandmorty.presentation.HeroesDetail.ViewModelDetail

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HeroesListScreen.route
    ) {

        composable(route = Screens.HeroesListScreen.route){
            val viewModel: ViewModel = hiltViewModel()

            HeroesScreen(
                state = viewModel.state.value,
                processEvent = viewModel::processEvent,
                onHeroDetailScreenClick = {
                    navController.navigate(Screens.HeroDetailsScreen.route + "?id=${it.id}")
                }
            )
        }
        composable(route = Screens.HeroDetailsScreen.route + "?id={id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val viewModel: ViewModelDetail = hiltViewModel()

            HeroesDetailScreen(
                state = viewModel.heroesState.value,
                processEvent = viewModel::processEvent,
            )

        }
    }
}


sealed class Screens(val route: String) {

    object HeroesListScreen: Screens("heroes_list_screen")

    object HeroDetailsScreen: Screens("hero_details_screen")
}