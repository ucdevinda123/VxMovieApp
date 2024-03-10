package com.spore.vxmoviesapp.ui.components.imageholders

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.spore.vxmoviesapp.R
import com.valentinilk.shimmer.shimmer

@Composable
fun VxLargeBannerMovieItem(posterUrl: String = "", modifier: Modifier = Modifier) {
    Surface(
        shape = RectangleShape,
        elevation = 0.dp,
        modifier = modifier,
    ) {
        val showShimmer = mutableStateOf(true)
        Box {
            val modifier: Modifier = if (showShimmer.value) {
                Modifier
                    .defaultMinSize(minWidth = 220.dp, minHeight = 500.dp)
                    .fillMaxSize()
            } else {
                Modifier
                    .blur(70.dp)
                    .defaultMinSize(minWidth = 220.dp, minHeight = 500.dp)
                    .fillMaxSize().shimmer()
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(posterUrl)
                    .crossfade(true)
                    .build(),
                onSuccess = { showShimmer.value = false },
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = modifier,
            )
        }
    }
}
