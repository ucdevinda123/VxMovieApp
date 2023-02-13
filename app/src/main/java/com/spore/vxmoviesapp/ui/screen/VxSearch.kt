package com.spore.vxmoviesapp.ui.screen

import SearchBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.spore.vxmoviesapp.ui.components.appbar.VxAppBarWithBack
import com.spore.vxmoviesapp.ui.viewmodel.SearchViewModel

@Composable
fun SearchMovies(navController: NavHostController, onNavigate:(id:Long)->Unit) {
    val searchViewModel: SearchViewModel = hiltViewModel()
    val movieDetailsState = searchViewModel.searchState.value.collectAsLazyPagingItems()

    Scaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            val homeScreenScrollState = rememberScrollState()

            VxAppBarWithBack(false, Modifier.padding(1.dp), navController)

            SearchBar(
                autoFocus = true,
                viewModel = searchViewModel,
                onSearch = {
                    searchViewModel.search("ss")
                }
            )
        }
    }
}