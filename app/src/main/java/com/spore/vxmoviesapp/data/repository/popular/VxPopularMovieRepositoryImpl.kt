package com.spore.vxmoviesapp.data.repository.popular

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.pagingsource.PopularMoviePagingSource
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class VxPopularMovieRepositoryImpl(var popularMoviePagingSource: PopularMoviePagingSource) : VxPopularMovieRepository {
    override suspend fun getPopularMovies(page: Int): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(
                pageSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { popularMoviePagingSource }
        ).flow
    }
}