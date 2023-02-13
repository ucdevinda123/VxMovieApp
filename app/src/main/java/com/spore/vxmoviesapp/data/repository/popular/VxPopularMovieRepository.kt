package com.spore.vxmoviesapp.data.repository.popular

import androidx.paging.PagingData
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface VxPopularMovieRepository {
    suspend fun getPopularMovies(page: Int=1): Flow<PagingData<Movie>>
}