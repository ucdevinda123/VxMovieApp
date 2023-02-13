package com.spore.vxmoviesapp.data.repository.nowplaying

import androidx.paging.PagingData
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface VxNowPlayingMovieRepository {
    suspend fun getNowPlayingMovies(page: Int=1): Flow<PagingData<Movie>>
}