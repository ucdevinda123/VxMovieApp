package com.spore.vxmoviesapp.data.repository.toprated

import androidx.paging.PagingData
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface VxTopRatedRepository {
    suspend fun getTopRatedMovies(page: Int): Flow<PagingData<Movie>>
}