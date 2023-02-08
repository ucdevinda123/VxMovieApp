package com.spore.vxmoviesapp.data.network.constant

object  ApiConstant {
    const val BASE_URL = "http://api.themoviedb.org/3/"

    const val MOVIE_POPULAR = "movie/popular"
    const val MOVIE_TOP_RATED = "movie/top_rated"
    const val MOVIE_NOW_PLAYING = "movie/now_playing"
    const val MOVIE = "movie/{movie_id}"
    const val MOVIE_VIDEO = "movie/{movie_id}/videos"
    const val SIMILAR_MOVIES = "movie/{movie_id}/similar"

    const val LANG_ENG = "en-US"
    const val MOVIE_IMAGE_BASE_URL_W500 = "https://image.tmdb.org/t/p/w500"
}
