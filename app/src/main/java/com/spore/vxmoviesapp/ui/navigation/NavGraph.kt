package com.spore.vxmoviesapp.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.spore.vxmoviesapp.ui.screen.MovieDetails
import com.spore.vxmoviesapp.ui.screen.SearchMovies
import com.spore.vxmoviesapp.ui.screen.VxMovieHome

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            VxMovieHome(onNavigate = { movieId ->
                navController.navigate(route = Screen.MovieDetailScreen.route)
            },
                onSearchNavigate = {
                    navController.navigate(route = Screen.SearchScreen.route)
                }
            )
        }
        composable(
            route = Screen.MovieDetailScreen.route,
        ) { from: NavBackStackEntry ->
            val arguments = requireNotNull(from.arguments)
            val movieId = arguments.getLong("movieId")
            MovieDetails(navController, 505642)
        }

        composable(route = Screen.SearchScreen.route) {
            SearchMovies(navController = navController, onNavigate = { movieId ->
                navController.navigate(route = Screen.MovieDetailScreen.route)
            })
        }
    }

}