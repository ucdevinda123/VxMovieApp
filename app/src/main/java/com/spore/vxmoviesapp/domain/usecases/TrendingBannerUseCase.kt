package com.spore.vxmoviesapp.domain.usecases

import com.spore.vxmoviesapp.data.repository.bannermovie.VxBannerMovieRepository
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.util.Resource
import javax.inject.Inject

class TrendingBannerUseCase @Inject constructor(var repository: VxBannerMovieRepository) {
    suspend fun getTrendingBannerUseCase() : Resource<Movie> {
        return repository.getTrendingMovies()
    }
}