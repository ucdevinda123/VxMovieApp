package com.spore.vxmoviesapp.data.repository.upcoming

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.pagingsource.UpcomingMoviePagingSource
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VxUpComingMovieRepositoryImpl @Inject constructor(private val upcomingMoviePagingSource: UpcomingMoviePagingSource) : VxUpComingMovieRepository{
    override suspend fun getUpComingMovies(page: Int): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(
                pageSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { upcomingMoviePagingSource }
        ).flow
    }
}