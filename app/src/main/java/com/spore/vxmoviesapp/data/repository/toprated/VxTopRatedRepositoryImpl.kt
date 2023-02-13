package com.spore.vxmoviesapp.data.repository.toprated

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.pagingsource.TopRatedMoviePagingSource
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VxTopRatedRepositoryImpl @Inject constructor(var topRatedMoviePagingSource: TopRatedMoviePagingSource) : VxTopRatedRepository {
    override suspend fun getTopRatedMovies(page: Int): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(
                pageSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { topRatedMoviePagingSource }
        ).flow
    }
}