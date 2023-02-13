package com.spore.vxmoviesapp.domain.usecases

import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.repository.upcoming.VxUpComingMovieRepository
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpComingMovieUseCase @Inject constructor(var repository: VxUpComingMovieRepository) {
    suspend fun getPopularMoviesUseCase() : Flow<PagingData<Movie>> {
       return repository.getUpComingMovies(1)
    }
}