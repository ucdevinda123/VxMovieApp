package com.spore.vxmoviesapp.domain.usecases

import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.repository.nowplaying.VxNowPlayingMovieRepository
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NowPlayingMovieUseCase @Inject constructor(var repository: VxNowPlayingMovieRepository) {
    suspend fun getNowPlayingMovies(): Flow<PagingData<Movie>> {
        return repository.getNowPlayingMovies(1)
    }
}