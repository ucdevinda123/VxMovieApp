package com.spore.vxmoviesapp.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.spore.vxmoviesapp.R
import com.spore.vxmoviesapp.ui.anim.getVxTopBarColorState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarHeightState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarWidthState
import com.spore.vxmoviesapp.ui.components.VxAppBar
import com.spore.vxmoviesapp.ui.components.VxTrendingTopTextBanner
import com.spore.vxmoviesapp.ui.components.carousal.VxMovieCarousal
import com.spore.vxmoviesapp.ui.components.imageholders.VxLargeBannerMovieItem
import com.spore.vxmoviesapp.ui.components.menubar.VxCategoryMenuBar
import com.spore.vxmoviesapp.ui.viewmodel.HomeViewModel
import com.spore.vxmoviesapp.ui.viewmodel.MainBannerViewModel
import com.spore.vxmoviesapp.util.isNetworkAvailable

@Composable
fun VxMovieHome(
    onNavigate: (id: Long) -> Unit,
    onSearchNavigate: () -> Unit,
    onMyListNavigate: () -> Unit,
) {
    val homeScreenScrollState = rememberScrollState()
    val homeViewModel: HomeViewModel = hiltViewModel()
    if (isNetworkAvailable(LocalContext.current)) {
        homeViewModel.getPopularMovies()
        homeViewModel.getUpComingMovies()
        homeViewModel.getTopRatedMovies()
        homeViewModel.getNowPlayingMovies()
    }

    val isScrolledDown = remember {
        derivedStateOf {
            homeScreenScrollState.value > 0
        }
    }
    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.verticalScroll(homeScreenScrollState)) {
                MainMovieLayout()
                MovieListScreens(homeViewModel, onNavigateMovieDetails = {
                    onNavigate(it)
                })
            }
            VxTopBar(isScrolledDown.value, onSearchItemTap = {
                onSearchNavigate()
            }, onMyListItemTap = {
                onMyListNavigate()
            })
        }
    }
}

@Composable
fun MovieListScreens(homeViewModel: HomeViewModel, onNavigateMovieDetails: (id: Long) -> Unit) {
    val popularMovies = homeViewModel.popularMovieState.value.collectAsLazyPagingItems()
    val upcomingMovies = homeViewModel.upcomingMovieState.value.collectAsLazyPagingItems()
    val topRatedMovies = homeViewModel.topRatedMovieState.value.collectAsLazyPagingItems()
    val nowPlayingMovies = homeViewModel.nowPlayingMovieState.value.collectAsLazyPagingItems()

    Spacer(modifier = Modifier.width(15.dp))
    VxMovieCarousal(stringResource(id = R.string.popular), popularMovies, false) {
        onNavigateMovieDetails(it)
    }
    Spacer(modifier = Modifier.width(15.dp))
    VxMovieCarousal(stringResource(id = R.string.top_rated), topRatedMovies, true, onItemClick = {
        onNavigateMovieDetails(it)
    })
    Spacer(modifier = Modifier.width(15.dp))
    VxMovieCarousal(stringResource(id = R.string.up_movies), upcomingMovies, false, onItemClick = {
        onNavigateMovieDetails(it)
    })

    Spacer(modifier = Modifier.width(15.dp))
    VxMovieCarousal(
        stringResource(id = R.string.now_playing),
        nowPlayingMovies,
        true,
        onItemClick = {
            onNavigateMovieDetails(it)
        },
    )
}

@Composable
fun MainMovieLayout(mainBannerViewModel: MainBannerViewModel = hiltViewModel()) {
    if (isNetworkAvailable(LocalContext.current)) {
        mainBannerViewModel.getTrendingBanner()
        val trendingBanner = mainBannerViewModel.trendingMovieState.value?.posterUrl
        ConstraintLayout {
            val (movieImage, topTrendingBanner) = createRefs()

            if (trendingBanner != null) {
                VxLargeBannerMovieItem(
                    posterUrl = trendingBanner,
                    modifier = Modifier.constrainAs(movieImage) {
                        top.linkTo(parent.top)
                    },
                )
            }
            VxTrendingTopTextBanner(
                modifier = Modifier.constrainAs(topTrendingBanner) {
                    bottom.linkTo(movieImage.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                text = stringResource(id = R.string.top_label),
                rating = stringResource(id = R.string.ten_label),
                enableTitle = true,
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun VxTopBar(
    isScrollingDown: Boolean,
    modifier: Modifier = Modifier,
    onSearchItemTap: () -> Unit,
    onMyListItemTap: () -> Unit,
) {
    Surface(
        modifier = modifier
            .padding(top = getVxTopBarWidthState(isScrolledDown = isScrollingDown).value)
            .height(getVxTopBarHeightState(isScrollingDown).value),
        color = getVxTopBarColorState(isScrolledDown = isScrollingDown).value,
    ) {
        TopAppBar(
            elevation = 0.dp,
            backgroundColor = Color.Transparent,
            modifier = Modifier.height(40.dp),
        ) {
            Column {
                Spacer(modifier = Modifier.height(5.dp))
                VxAppBar(onSearchItemTap = {
                    onSearchItemTap()
                }, onMyListItemTap = {
                    onMyListItemTap()
                })
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility(visible = isScrollingDown.not()) {
                    VxCategoryMenuBar()
                }
            }
        }
    }
}
