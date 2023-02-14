package com.spore.vxmoviesapp.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.domain.usecases.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val searchUseCase: SearchUseCase) : ViewModel() {

    private var _searchResult = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val searchState: State<Flow<PagingData<Movie>>> = _searchResult

    private var _searchQuery = mutableStateOf("")
    val searchQueryState: State<String> = _searchQuery

    fun search(searchText: String) {
        viewModelScope.launch {
            _searchQuery.value = searchText
            val searchResponse = searchUseCase.search(searchText).cachedIn(viewModelScope)
            _searchResult.value = searchResponse
        }
    }
}