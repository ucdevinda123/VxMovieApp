package com.spore.vxmoviesapp.domain.usecases

import com.spore.vxmoviesapp.data.repository.moviedetails.VxMovieDetails
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.util.Resource
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(var repository: VxMovieDetails) {

    suspend fun getMovieDetailsUseCase(movieId: Long): Resource<Movie> {
        return repository.getMovieDetails(movieId)
    }
}