package com.spore.vxmoviesapp.ui.components.imageholders

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.spore.vxmoviesapp.R

@Composable
fun VxLargeBannerMovieItem(posterUrl: String = "", modifier: Modifier = Modifier) {
    Surface(
        shape = RectangleShape,
        color = Color.LightGray,
        elevation = 0.dp,
        modifier = modifier,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(posterUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.poster),
            contentDescription = stringResource(R.string.app_name),
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize(),
        )
    }
}
