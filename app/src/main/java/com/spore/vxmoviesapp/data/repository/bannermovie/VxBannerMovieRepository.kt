package com.spore.vxmoviesapp.data.repository.bannermovie

import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.util.Resource

interface VxBannerMovieRepository {
    suspend fun getTrendingMovies() : Resource<Movie>
}