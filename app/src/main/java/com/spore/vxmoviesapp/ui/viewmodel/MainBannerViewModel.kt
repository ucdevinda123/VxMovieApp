package com.spore.vxmoviesapp.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.domain.usecases.TrendingBannerUseCase
import com.spore.vxmoviesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainBannerViewModel @Inject constructor(
    private val trendingBannerUseCase: TrendingBannerUseCase
) : ViewModel() {
    private var _trendingMovie = mutableStateOf<Movie?>(null)
    val trendingMovieState: State<Movie?> = _trendingMovie

    fun getTrendingBanner() {
        viewModelScope.launch {
            when (val response = trendingBannerUseCase.getTrendingBannerUseCase()) {
                is Resource.Success -> {
                    _trendingMovie.value = response.data
                }
                else -> {}
            }
        }
    }
}