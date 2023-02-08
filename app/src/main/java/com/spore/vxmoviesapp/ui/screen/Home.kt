package com.spore.vxmoviesapp.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.spore.vxmoviesapp.R
import com.spore.vxmoviesapp.ui.anim.getVxTopBarColorState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarHeightState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarWidthState
import com.spore.vxmoviesapp.ui.components.VxAppBar
import com.spore.vxmoviesapp.ui.components.VxMenuBarItem
import com.spore.vxmoviesapp.ui.components.VxRoundedButton

@Composable
fun VxMainViewContainer() {
    val homeScreenScrollState = rememberScrollState()
    val isScrolledDown = remember {
        derivedStateOf {
            homeScreenScrollState.value > 0
        }
    }
    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.verticalScroll(homeScreenScrollState)) {
                MainMovieLayout()
                Spacer(modifier = Modifier.width(15.dp))
                PopularCarousal()
                Spacer(modifier = Modifier.width(15.dp))
                PopularCarousal()
            }
            VxTopBar(isScrolledDown.value)
        }
    }
}


@Composable
fun MainMovieLayout() {
    ConstraintLayout {
        val (movieImage, topTrendingBanner, trendingList) = createRefs()
        MainMovieItem(modifier = Modifier.constrainAs(movieImage) {
            top.linkTo(parent.top)
        })
        TrendingTopTextBanner(
            modifier = Modifier.constrainAs(topTrendingBanner) {
                bottom.linkTo(movieImage.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun PopularCarousal() {
    Column(modifier = Modifier.padding(5.dp)) {
        Row(Modifier.fillMaxWidth()) {
            Text(
                text = "New Originals",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                ),
                color = Color.White,
                modifier = Modifier
                    .padding(start = 2.dp)
                    .weight(2f)
            )


            VxRoundedButton(text = "View More", modifier = Modifier
                .padding(start = 2.dp)
                .weight(1f), onClick = {
                println("Hello")
            })
        }

        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(modifier = Modifier.padding(8.dp)) {
            val ss = arrayListOf("1", "2", "2", "2", "2")

            items(ss) {
                LargeMovieItem()
            }
        }
    }
}

@Composable
fun TrendingTopTextBanner(
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            color = Color.Red,
            shape = RoundedCornerShape(10),
            modifier = modifier
                .size(28.dp, 28.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Top",
                    fontSize = 8.sp,
                    style = MaterialTheme.typography.button,
                    maxLines = 1
                )

                Text(
                    text = "10",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.button,
                    maxLines = 1
                )
            }


        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "1# In America",
            fontSize = 14.sp,
            letterSpacing = (-0.10).sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.button,
            maxLines = 1
        )
    }
}

@Composable
fun MainMovieItem(modifier: Modifier) {
    Surface(
        shape = RectangleShape,
        color = Color.LightGray,
        elevation = 0.dp,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.poster
            ),
            contentDescription = "main banner image",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )


    }
}

@Composable
fun LargeMovieItem() {
    ConstraintLayout {
        val (movieImage) = createRefs()
        Surface(
            color = Color.LightGray,
            shape = RoundedCornerShape(3),
            elevation = 2.dp,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.poster),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(170.dp)
                    .height(320.dp)
                    .clickable(onClick = {
                        // onMovieSelected(movie.id)
                    })
                    .constrainAs(movieImage) {
                        top.linkTo(parent.bottom)
                    },
            )

        }
    }
}

@Composable
fun VxTopBar(
    isScrollingDown: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(top = getVxTopBarWidthState(isScrolledDown = isScrollingDown).value)
            .height(getVxTopBarHeightState(isScrollingDown).value),
        color = getVxTopBarColorState(isScrolledDown = isScrollingDown).value
    ) {
        TopAppBar(
            elevation = 0.dp,
            backgroundColor = Color.Transparent,
            modifier = Modifier.height(40.dp)
        ) {
            Column {
                Spacer(modifier = Modifier.height(5.dp))
                VxAppBar()
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility(visible = isScrollingDown.not()) {
                    MenuBar()
                }
            }
        }
    }
}

@Composable
fun MenuBar() {
    Row {
        VxMenuBarItem(
            text = "TV Shows",
            modifier = Modifier.weight(1f),
        )
        VxMenuBarItem(text = "Movies", modifier = Modifier.weight(1f))
        VxMenuBarItem(text = "Categories", modifier = Modifier.weight(1f))
    }
}


