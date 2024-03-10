package com.spore.vxmoviesapp.data.network

import com.spore.vxmoviesapp.data.network.constant.ApiConstant
import com.spore.vxmoviesapp.data.network.dto.MovieDetailsDto
import com.spore.vxmoviesapp.data.network.dto.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitMovieService {

    @GET(ApiConstant.MOVIE_POPULAR)
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("include_adult") includeAdult: Boolean = false,
    ): MovieResponseDto

    @GET(ApiConstant.MOVIE_UPCOMING)
    suspend fun getUpcomingMovies(
        @Query("page") page: Int = 1,
        @Query("include_adult") includeAdult: Boolean = false,
    ): MovieResponseDto

    @GET(ApiConstant.MOVIE_TOP_RATED)
    suspend fun getTopRatedMovies(
        @Query("page") page: Int = 1,
        @Query("include_adult") includeAdult: Boolean = false,
    ): MovieResponseDto

    @GET(ApiConstant.MOVIE_NOW_PLAYING)
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int = 1,
        @Query("include_adult") includeAdult: Boolean = false,
    ): MovieResponseDto

    @GET(ApiConstant.MOVIE_NOW_TRENDING)
    suspend fun getTrendingMovies(
        @Query("page") page: Int = 1,
        @Query("include_adult") includeAdult: Boolean = false,
    ): MovieResponseDto

    @GET(ApiConstant.SEARCH_MOVIES)
    suspend fun searchMovies(
        @Query("page") page: Int = 1,
        @Query("query") searchParams: String,
        @Query("include_adult") includeAdult: Boolean = false,
    ): MovieResponseDto

    @GET(ApiConstant.MOVIE)
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Long,
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("page") page: Int = 1,
    ): MovieDetailsDto
}
