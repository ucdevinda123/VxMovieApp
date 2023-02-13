package com.spore.vxmoviesapp.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.domain.usecases.NowPlayingMovieUseCase
import com.spore.vxmoviesapp.domain.usecases.PopularMovieUseCase
import com.spore.vxmoviesapp.domain.usecases.TopRateMovieUseCase
import com.spore.vxmoviesapp.domain.usecases.UpComingMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var popularMoviesUseCase: PopularMovieUseCase,
    var topRateMovieUseCase: TopRateMovieUseCase,
    var upComingMovieUseCase: UpComingMovieUseCase,
    private val nowPlayingMovieUseCase: NowPlayingMovieUseCase,

    ) : ViewModel() {

    private var _popularMovies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val popularMovieState: State<Flow<PagingData<Movie>>> = _popularMovies

    private var _upcomingMovies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val upcomingMovieState: State<Flow<PagingData<Movie>>> = _upcomingMovies

    private var _topRatedMovies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val topRatedMovieState: State<Flow<PagingData<Movie>>> = _topRatedMovies

    private var _nowPlayingMovies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val nowPlayingMovieState: State<Flow<PagingData<Movie>>> = _nowPlayingMovies


    fun getPopularMovies() {
        viewModelScope.launch {
            val response = popularMoviesUseCase.getPopularMoviesUseCase().cachedIn(viewModelScope)
            _popularMovies.value = response
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch {
            val response = topRateMovieUseCase.getPopularMoviesUseCase().cachedIn(viewModelScope)
            _topRatedMovies.value = response
        }
    }

    fun getUpComingMovies() {
        viewModelScope.launch {
            val response = upComingMovieUseCase.getPopularMoviesUseCase().cachedIn(viewModelScope)
            _upcomingMovies.value = response
        }
    }

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            val response = nowPlayingMovieUseCase.getNowPlayingMovies().cachedIn(viewModelScope)
            _nowPlayingMovies.value = response
        }
    }
}