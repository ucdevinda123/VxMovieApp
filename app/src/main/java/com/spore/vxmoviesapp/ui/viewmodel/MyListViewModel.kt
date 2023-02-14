package com.spore.vxmoviesapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spore.vxmoviesapp.data.offline.entity.MyList
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.domain.usecases.WatchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor(val watchListUseCase: WatchListUseCase) : ViewModel() {

    private val _watchList = mutableStateOf<Flow<List<MyList>>>(emptyFlow())
    var watchList: MutableState<Flow<List<MyList>>> = _watchList

    private val _isItemExists = mutableStateOf(false)
    var isExists: MutableState<Boolean> = _isItemExists

    init {
        getAllWatchListMovies()
    }

    fun insertToWatchList(movie: Movie) {
        viewModelScope.launch {
            watchListUseCase.insertToWatchList(movie)
        }
    }

    fun removeFromWatchList(mediaId: Long) {
        viewModelScope.launch {
            watchListUseCase.removeFromList(mediaId)
        }
    }

    fun getAllWatchListMovies() {
        watchList.value = watchListUseCase.getAllWatchListMovies()
    }

    fun isItemExistsInTheWatchList(mediaId: Long) {
        viewModelScope.launch {
            isExists.value = watchListUseCase.isExitInTheWatchList(mediaId)
        }
    }
}