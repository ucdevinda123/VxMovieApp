package com.spore.vxmoviesapp.data.repository.upcoming

import androidx.paging.PagingData
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface VxUpComingMovieRepository {
    suspend fun getUpComingMovies(page: Int): Flow<PagingData<Movie>>
}