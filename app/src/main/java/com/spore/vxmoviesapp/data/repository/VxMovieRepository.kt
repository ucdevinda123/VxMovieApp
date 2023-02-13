package com.spore.vxmoviesapp.data.repository

import androidx.paging.PagingData
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface VxMovieRepository {

   suspend fun getPopularMovies(page: Int): Flow<PagingData<Movie>>
   suspend fun getUpComingMovies(page: Int): Flow<PagingData<Movie>>

}