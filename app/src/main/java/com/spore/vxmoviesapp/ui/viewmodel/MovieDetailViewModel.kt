package com.spore.vxmoviesapp.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.domain.usecases.MovieDetailsUseCase
import com.spore.vxmoviesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailsUseCase,
) : ViewModel() {
    private var _detailMovie = mutableStateOf<Movie?>(null)
    val detailMovieState: State<Movie?> = _detailMovie

    fun getMovieDetails(id: Long) {
        viewModelScope.launch {
            when (val response = movieDetailsUseCase.getMovieDetailsUseCase(id)) {
                is Resource.Success -> {
                    _detailMovie.value = response.data
                }
                else -> {
                    Resource.Error("Unable to get movie details")
                }
            }
        }
    }
}
