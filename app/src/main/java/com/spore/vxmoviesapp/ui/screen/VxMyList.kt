package com.spore.vxmoviesapp.ui.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.spore.vxmoviesapp.R
import com.spore.vxmoviesapp.ui.components.appbar.VxAppBarWithBack
import com.spore.vxmoviesapp.ui.components.searchgrid.VxMovieGrid
import com.spore.vxmoviesapp.ui.viewmodel.SearchViewModel

@Composable
fun VxMyList(navController: NavHostController, onNavigate: (id: Long) -> Unit) {
    val searchViewModel: SearchViewModel = hiltViewModel()
    Scaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            val movieSearchState = searchViewModel.searchState.value.collectAsLazyPagingItems()
            VxAppBarWithBack(
                false,
                Modifier.padding(1.dp),
                navController,
                stringResource(id = R.string.my_list)
            )

            VxMovieGrid(
                stringResource(id = R.string.search_movies_and_tv_shows),
                movieSearchState,
                3,
                onItemClick = {
                    onNavigate(it)
                })
        }
    }
}