package com.spore.vxmoviesapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.pagingsource.TopRatedMoviePagingSource
import com.spore.vxmoviesapp.data.pagingsource.PopularMoviePagingSource
import com.spore.vxmoviesapp.data.pagingsource.UpcomingMoviePagingSource
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VxMovieRepositoryImpl @Inject constructor(
    var upcomingPagingSource: UpcomingMoviePagingSource,
    private var popularPagingSource: PopularMoviePagingSource
) :
    VxMovieRepository {
    override suspend fun getPopularMovies(page: Int): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(
                pageSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { popularPagingSource }
        ).flow
    }

    override suspend fun getUpComingMovies(page: Int): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(
                pageSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { upcomingPagingSource }
        ).flow
    }


}


sealed class VxMovieQuery {
    data class Search(val query: String) : VxMovieQuery()
    object TopMovies : VxMovieQuery()
    object PopularMovies : VxMovieQuery()
    object NowAiring : VxMovieQuery()
    object Upcoming : VxMovieQuery()
}