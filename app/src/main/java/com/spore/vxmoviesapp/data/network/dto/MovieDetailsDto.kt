package com.spore.vxmoviesapp.data.network.dto

import com.google.gson.annotations.SerializedName
import com.spore.vxmoviesapp.data.network.constant.ApiConstant
import com.spore.vxmoviesapp.domain.model.Movie

data class MovieDetailsDto(
    val id: Long,
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backDropPath: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("genres")
    val genres: List<Genres>,
    @SerializedName("original_language")
    val originalLanguage: String,
    val title: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("release_date")
    val releaseDate: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val avgVote: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("runtime")
    val runtime: Int
) {

    fun asDomainModel() = Movie(
        id = id,
        isAdult = adult,
        backDropUrl = ApiConstant.MOVIE_IMAGE_BASE_URL_W500 + backDropPath,
        posterUrl = ApiConstant.MOVIE_IMAGE_BASE_URL_W500 + posterPath,
        genreIds = genres.map { it.id },
        genres = genres.map { it.name },
        language = originalLanguage,
        title = title,
        overview = overview,
        popularity = popularity,
        releaseDate = releaseDate,
        isVideoAvailable = video,
        avgVote = avgVote,
        voteCount = voteCount,
        runtime = runtime
    )
}

data class Genres(
    val id: Int,
    val name: String
)