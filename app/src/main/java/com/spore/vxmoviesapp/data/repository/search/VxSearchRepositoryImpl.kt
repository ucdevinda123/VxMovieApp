package com.spore.vxmoviesapp.data.repository.search

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.network.RetrofitMovieService
import com.spore.vxmoviesapp.data.pagingsource.SearchPagingSource
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VxSearchRepositoryImpl @Inject constructor(var vxApi:RetrofitMovieService) : VxSearchRepository {
    override suspend fun searchMovies(searchText: String, page: Int): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SearchPagingSource(
                    vxMovieApi = vxApi,
                    searchQuery = searchText,
                )
            }
        ).flow
    }
}