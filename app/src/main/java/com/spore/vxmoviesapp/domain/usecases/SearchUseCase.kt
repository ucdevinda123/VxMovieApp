package com.spore.vxmoviesapp.domain.usecases

import androidx.paging.PagingData
import com.spore.vxmoviesapp.data.repository.search.VxSearchRepository
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(var repository: VxSearchRepository) {
    suspend fun search(searchText : String) : Flow<PagingData<Movie>> {
       return repository.searchMovies(searchText)
    }
}