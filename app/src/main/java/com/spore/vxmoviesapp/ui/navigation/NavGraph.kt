package com.spore.vxmoviesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.spore.vxmoviesapp.ui.navigation.NavigationParamKeys.MOVIE_ID_KEY
import com.spore.vxmoviesapp.ui.screen.MovieDetails
import com.spore.vxmoviesapp.ui.screen.SearchMovies
import com.spore.vxmoviesapp.ui.screen.VxMovieHome
import com.spore.vxmoviesapp.ui.screen.VxMyList

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            VxMovieHome(
                onNavigate = { movieId ->
                    navController.navigate("${Screen.MovieDetailScreen.route}/$movieId")
                },
                onSearchNavigate = {
                    navController.navigate(route = Screen.SearchScreen.route)
                },
                onMyListNavigate = {
                    navController.navigate(route = Screen.MyListScreen.route)
                },
            )
        }
        composable(
            route = "${Screen.MovieDetailScreen.route}/{$MOVIE_ID_KEY}",
            arguments = listOf(navArgument(MOVIE_ID_KEY) { type = NavType.LongType }),
        ) { from: NavBackStackEntry ->
            val arguments = requireNotNull(from.arguments)
            val movieId = arguments.getLong(MOVIE_ID_KEY)
            MovieDetails(navController, movieId)
        }

        composable(route = Screen.SearchScreen.route) {
            SearchMovies(navController = navController, onNavigate = { movieId ->
                navController.navigate("${Screen.MovieDetailScreen.route}/$movieId")
            })
        }

        composable(route = Screen.MyListScreen.route) {
            VxMyList(navController = navController, onNavigate = { movieId ->
                navController.navigate("${Screen.MovieDetailScreen.route}/$movieId")
            })
        }
    }
}
