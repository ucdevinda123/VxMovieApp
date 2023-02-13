package com.spore.vxmoviesapp.ui.components.appbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.spore.vxmoviesapp.data.network.constant.ApiConstant
import com.spore.vxmoviesapp.ui.anim.getVxTopBarColorState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarHeightState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarWidthState


@Composable
fun VxAppBarWithBack(
    isScrollingDown: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController,

) {
    Surface(
        modifier = modifier
            .padding(top = getVxTopBarWidthState(isScrolledDown = isScrollingDown).value)
            .height(getVxTopBarHeightState(isScrollingDown).value),
        color = getVxTopBarColorState(isScrolledDown = isScrollingDown).value
    ) {
        Box(modifier=Modifier.fillMaxHeight().fillMaxWidth()) {
            TopAppBar(
                elevation = 0.dp,
                backgroundColor = Color.Transparent,
                modifier = Modifier.height(40.dp)
            ) {
                Column {
                    VxAppBarBackButton(navController)
                    Spacer(modifier = Modifier.height(10.dp))
                    AnimatedVisibility(visible = isScrollingDown.not()) {

                    }
                }
            }
        }

    }
}

@Composable
fun VxAppBarBackButton(
    navController: NavHostController
) {
    Row(Modifier.padding(start = 1.dp)) {
        Box(
            modifier = Modifier
                .weight(6f)
                .align(Alignment.CenterVertically)
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    }
/*
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF180E36))
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.33F)
        ) {
            val (
                backdropImage,
                backButton,
                movieTitleBox,
                moviePosterImage,
                translucentBr
            ) = createRefs()

            AsyncImage(model = ApiConstant.MOVIE_IMAGE_BASE_URL_W500 +"/t72ZvOZwtvcjZivZCFtCtL8QWb0.jpg",
                contentDescription ="",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                    .constrainAs(backdropImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }

            )


           *//* AsyncImage(
                imageModel = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                    .fillMaxHeight()
                    .constrainAs(backdropImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                contentScale = ContentScale.Crop,
                contentDescription = "Header backdrop image",
            )*//*

            *//*   BackButton(modifier = Modifier
                .constrainAs(backButton) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }) {
                navigator.navigateUp()
            }*//*

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color(0XFF180E36).copy(alpha = 0.5F),
                                Color(0XFF180E36)
                            ),
                            startY = 0.1F
                        )
                    )
                    .constrainAs(translucentBr) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(backdropImage.bottom)
                    }
            )

            Column(
                modifier = Modifier.constrainAs(movieTitleBox) {
                    start.linkTo(moviePosterImage.end, margin = 12.dp)
                    end.linkTo(parent.end, margin = 12.dp)
                    bottom.linkTo(moviePosterImage.bottom, margin = 10.dp)
                },
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    *//*               Text(
                        text = when (filmType) {
                            FilmType.TVSHOW -> "Series"
                            FilmType.MOVIE -> "Movie"
                        },
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(size = 4.dp))
                            .background(Color.DarkGray.copy(alpha = 0.65F))
                            .padding(2.dp),
                        color = AppOnPrimaryColor.copy(alpha = 0.78F),
                        fontSize = 12.sp,
                    )
                    Text(
                        text = when (film.adult) {
                            true -> "18+"
                            else -> "PG"
                        },
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .clip(shape = RoundedCornerShape(size = 4.dp))
                            .background(
                                if (film.adult) Color(0xFFFF7070) else Color.DarkGray.copy(
                                    alpha = 0.65F
                                )
                            )
                            .padding(2.dp),
                        color = AppOnPrimaryColor.copy(alpha = 0.78F),
                        fontSize = 12.sp,
                    )*//*
                }

                Text(
                    text = "Testt",
                    modifier = Modifier
                        .padding(top = 2.dp, start = 4.dp, bottom = 4.dp)
                        .fillMaxWidth(0.5F),
                    maxLines = 2,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha = 0.78F)
                )

                Text(
                    text = "20202020",
                    modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White.copy(alpha = 0.56F)
                )



                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 4.dp, bottom = 8.dp)
                        .fillMaxWidth(0.42F),
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Refresh,
                        tint = Color.Transparent,
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {

                            },
                        contentDescription = "reviews icon"
                    )
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Rounded.PlayArrow,
                            tint = Color.Red,
                            contentDescription = "play icon"
                        )
                    }

                    val context = LocalContext.current
                    IconButton(onClick = {

                    }) {
                        *//*Icon(
                            painter = painterResource(
                                id = R
                                else R.drawable.ic_add_to_list
                            ),
                            tint = AppOnPrimaryColor,
                            contentDescription = "add to watch list icon"
                        )*//*
                    }
                }
            }

*//*            AsyncImage(
                imageModel = "",
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .width(115.dp)
                    .height(172.5.dp)
                    .constrainAs(moviePosterImage) {
                        top.linkTo(backdropImage.bottom)
                        bottom.linkTo(backdropImage.bottom)
                        start.linkTo(parent.start)
                    }, failure = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image_not_available),
                            contentDescription = "no image"
                        )
                    }
                },
                shimmerParams = ShimmerParams(
                    baseColor = AppPrimaryColor,
                    highlightColor = ButtonColor,
                    durationMillis = 500,
                    dropOff = 0.65F,
                    tilt = 20F
                ),
                previewPlaceholder = R.drawable.popcorn,
                contentScale = ContentScale.Crop,
                circularReveal = CircularReveal(duration = 1000),
                contentDescription = "movie poster"
            )*//*
        }

    }*/
}
