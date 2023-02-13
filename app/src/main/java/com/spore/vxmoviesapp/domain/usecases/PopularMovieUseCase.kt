package com.spore.vxmoviesapp.domain.usecases

import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.repository.popular.VxPopularMovieRepository
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(var repository: VxPopularMovieRepository) {
    suspend fun getPopularMoviesUseCase() : Flow<PagingData<Movie>> {
       return repository.getPopularMovies()
    }
}