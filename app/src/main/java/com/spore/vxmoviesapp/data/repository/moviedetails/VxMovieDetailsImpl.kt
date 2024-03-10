package com.spore.vxmoviesapp.data.repository.moviedetails

import com.spore.vxmoviesapp.data.network.RetrofitMovieService
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.util.Resource
import java.io.IOException
import javax.inject.Inject

class VxMovieDetailsImpl @Inject constructor(var vxMovieApi: RetrofitMovieService) : VxMovieDetails {
    override suspend fun getMovieDetails(movieId: Long): Resource<Movie> {
        return try {
            val movie = vxMovieApi.getMovieDetails(movieId).asDomainModel()
            Resource.Success(movie)
        } catch (ex: IOException) {
            Resource.Error("Unable to get movie details")
        }
    }
}
