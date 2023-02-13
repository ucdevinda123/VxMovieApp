package com.spore.vxmoviesapp.data.repository.search

import androidx.paging.PagingData
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface VxSearchRepository  {
    suspend fun searchMovies(searchText:String,page: Int=1): Flow<PagingData<Movie>>
}