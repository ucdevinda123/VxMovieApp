package com.spore.vxmoviesapp.ui.navigation

sealed class Screen(val route:String){
    object  HomeScreen : Screen("home_screen")
    object  MovieDetailScreen : Screen("movieDetail")
    object  SearchScreen : Screen("search")
    object  MyListScreen : Screen("mylist")

}

object NavigationParamKeys {
    const val MOVIE_ID_KEY = "movieId"
}
