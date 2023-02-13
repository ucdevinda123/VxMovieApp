package com.spore.vxmoviesapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.ui.components.VxRoundedImage
import com.spore.vxmoviesapp.ui.components.appbar.VxAppBarWithBack
import com.spore.vxmoviesapp.ui.components.imageholders.VxLargeBannerMovieItem
import com.spore.vxmoviesapp.ui.viewmodel.MovieDetailViewModel
import com.spore.vxmoviesapp.util.DateUtils

@Composable
fun MovieDetails(navController: NavHostController, movieId: Long) {
    val movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
    movieDetailViewModel.getMovieDetails(movieId)
    val movieDetailsState = movieDetailViewModel.detailMovieState.value

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            val homeScreenScrollState = rememberScrollState()
            Column(modifier = Modifier.verticalScroll(homeScreenScrollState)) {
                ConstraintLayout {
                    val (movieImage, backDropBanner) = createRefs()
                    movieDetailsState?.let { it1 ->
                        VxLargeBannerMovieItem(
                            posterUrl = it1.backDropUrl,
                            Modifier.fillMaxSize().height(300.dp).constrainAs(backDropBanner) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            })
                    }
                    Column(modifier = Modifier.constrainAs(movieImage) {
                        top.linkTo(backDropBanner.bottom)
                        bottom.linkTo(backDropBanner.bottom)
                        start.linkTo(parent.start)
                    }) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .fillMaxWidth()
                                .height(172.5.dp)
                        ) {
                            movieDetailsState?.let { movieIt ->
                                Column(modifier = Modifier.fillMaxWidth()) {
                                    Row(modifier = Modifier.fillMaxWidth()) {
                                        VxRoundedImage(
                                            imageUrl = movieIt.posterUrl,
                                            modifier = Modifier
                                                .width(110.dp)
                                                .height(150.dp)
                                                .padding(10.dp)
                                                .clickable(onClick = {
                                                }),
                                            cornerPercent = 3
                                        )
                                        Column(
                                            Modifier
                                                .wrapContentWidth()
                                        ) {
                                            Text(
                                                text = movieDetailsState.title,
                                                modifier = Modifier
                                                    .wrapContentWidth()
                                                    .padding(top = 6.dp),
                                                fontWeight = FontWeight.Bold,
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Text(
                                                text = DateUtils.formatFilmDuration(movieIt.runtime),
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Light,
                                                color = Color.White
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Row {
                                                Text(
                                                    text = movieDetailsState.releaseDate.substring(
                                                        0,
                                                        4
                                                    ),
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Light,
                                                    color = Color.White
                                                )
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Box(
                                                    modifier = Modifier
                                                        .background(
                                                            color = Color.DarkGray,
                                                            shape = RoundedCornerShape(8)
                                                        )
                                                        .padding(
                                                            start = 4.dp,
                                                            top = 1.dp,
                                                            end = 4.dp,
                                                            bottom = 1.dp
                                                        )
                                                ) {
                                                    Text(
                                                        text = movieDetailsState.popularity.toString(),
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.Light,
                                                        color = Color.LightGray
                                                    )
                                                }
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Text(
                                                    text = DateUtils.formatFilmDuration(
                                                        movieDetailsState.runtime
                                                    ),
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Light,
                                                    color = Color.LightGray
                                                )
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Box(
                                                    modifier = Modifier
                                                        .background(
                                                            color = Color.LightGray,
                                                            shape = RoundedCornerShape(8)
                                                        )
                                                        .padding(
                                                            start = 3.dp,
                                                            top = 0.dp,
                                                            end = 3.dp,
                                                            bottom = 0.dp
                                                        )
                                                ) {
                                                    Text(
                                                        text = "HD",
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.Light,
                                                        color = Color.Black,
                                                        letterSpacing = 2.sp
                                                    )
                                                }
                                            }
                                            Spacer(modifier = Modifier.width(5.dp))
                                            Spacer(modifier = Modifier.height(20.dp))
                                            Row {
                                                ImageButton(
                                                    modifier = Modifier.padding(start = 10.dp, end = 30.dp),
                                                    icon = Icons.Default.Add,
                                                    text = "My List",
                                                    movieIt
                                                )
                                                ImageButton(
                                                    modifier = Modifier.padding(start = 10.dp, end = 30.dp),
                                                    icon = Icons.Outlined.ThumbUp,
                                                    text = "Like",
                                                    movieIt
                                                )
                                                ImageButton(
                                                    modifier = Modifier.padding(start = 10.dp, end = 30.dp),
                                                    icon = Icons.Outlined.Share,
                                                    text = "Share",
                                                    movieIt
                                                )
                                            }

                                        }

                                    }
                                }
                            }
                        }
                    }
                }
                movieDetailsState?.let { it1 ->
                    Text(
                        text = it1.overview,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Justify,
                        fontWeight = FontWeight.Light,
                        maxLines = 6,
                        lineHeight = 18.sp,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White,
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp)
                    )
                }
            }
            VxAppBarWithBack(false, Modifier.padding(1.dp), navController,"")
        }
    }
}


@Preview
@Composable
fun PreviewMovieDetail() {
    //MovieDetails()
}

@Composable
fun ImageButton(
    modifier: Modifier,
    icon: ImageVector,
    text: String,
    movie: Movie
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.selectable(selected = false, onClick = {

        })
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            fontSize = 10.sp,
            style = MaterialTheme.typography.button,
            maxLines = 1
        )
    }
}