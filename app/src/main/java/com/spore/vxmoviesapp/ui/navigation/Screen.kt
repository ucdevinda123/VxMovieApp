package com.spore.vxmoviesapp.ui.navigation

sealed class Screen(val route:String){
    object  HomeScreen : Screen("home_screen")
    object  MovieDetailScreen : Screen("movie_detail_screen")
    object  SearchScreen : Screen("search")
    object  MyListScreen : Screen("mylist")
}

const val movieId = "movieId"
