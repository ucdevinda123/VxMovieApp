package com.spore.vxmoviesapp.domain.model

data class Movie(
    val id: Long,
    val isAdult: Boolean,
    val backDropUrl: String,
    val posterUrl: String,
    val genreIds: List<Int>,
    val genres: List<String> = listOf(),
    val language: String,
    val title: String,
    val overview: String,
    val popularity: Double,
    val releaseDate: String,
    val isVideoAvailable: Boolean,
    val avgVote: Double,
    val voteCount: Int,
    val runtime: Int
)