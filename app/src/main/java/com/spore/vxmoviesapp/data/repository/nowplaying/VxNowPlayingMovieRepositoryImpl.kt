package com.spore.vxmoviesapp.data.repository.nowplaying

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.pagingsource.NowPlayingMoviePagingSource
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VxNowPlayingMovieRepositoryImpl  @Inject constructor(var nowPlayingMovieSource: NowPlayingMoviePagingSource) : VxNowPlayingMovieRepository {
    override suspend fun getNowPlayingMovies(page: Int): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { nowPlayingMovieSource }
        ).flow
    }
}