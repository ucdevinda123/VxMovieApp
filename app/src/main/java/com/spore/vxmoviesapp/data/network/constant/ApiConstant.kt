package com.spore.vxmoviesapp.data.network.constant

object  ApiConstant {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    const val MOVIE_GENRE_LIST = "genre/movie/list"
    const val MOVIE_POPULAR = "movie/popular"
    const val MOVIE_UPCOMING = "movie/upcoming"
    const val MOVIE_TOP_RATED = "movie/top_rated"
    const val MOVIE_NOW_PLAYING = "movie/now_playing"
    const val MOVIE_NOW_TRENDING = "trending/movie/week"
    const val MOVIE = "movie/{movie_id}"
    const val SEARCH_MOVIES = "search/movie?query"
    const val MOVIE_VIDEO = "movie/{movie_id}/videos"
    const val SIMILAR_MOVIES = "movie/{movie_id}/similar"

    const val LANG_ENG = "en-US"
    const val MOVIE_IMAGE_BASE_URL_W500 = "https://image.tmdb.org/t/p/w500"
    const val KEY = "5de5f6163222529e69d1516234729b6b"
}
