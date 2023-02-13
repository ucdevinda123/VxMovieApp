package com.spore.vxmoviesapp.data.repository.moviedetails

import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.util.Resource

interface VxMovieDetails {
    suspend fun getMovieDetails(movieId: Long) : Resource<Movie>
}