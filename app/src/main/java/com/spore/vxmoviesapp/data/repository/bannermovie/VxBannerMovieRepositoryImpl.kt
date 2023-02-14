package com.spore.vxmoviesapp.data.repository.bannermovie

import com.spore.vxmoviesapp.data.network.RetrofitMovieService
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.util.Resource
import javax.inject.Inject

class VxBannerMovieRepositoryImpl @Inject constructor(var vxMovieApi: RetrofitMovieService) :
    VxBannerMovieRepository {
    override suspend fun getTrendingMovies(): Resource<Movie> {
        val resultList = vxMovieApi.getTrendingMovies().results
        if (resultList.isNotEmpty()) {
            return Resource.Success(data = resultList[3].asDomainModel())
        }
        return Resource.Error("No movies to display")

    }
}