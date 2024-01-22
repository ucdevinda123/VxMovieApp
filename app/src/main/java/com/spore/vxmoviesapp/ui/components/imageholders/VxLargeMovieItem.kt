package com.spore.vxmoviesapp.ui.components.imageholders

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.ui.components.VxTrendingTopTextBanner

@Composable
fun VxLargeMovieItem(movie: Movie, onMovieItemClick: (movie: Movie) -> Unit) {
    ConstraintLayout {
        val (movieImage, topRate) = createRefs()
        Surface(
            color = Color.LightGray,
            shape = RoundedCornerShape(3),
            elevation = 2.dp,
            modifier = Modifier.padding(8.dp),
        ) {
            Image(
                painter = rememberAsyncImagePainter(movie.posterUrl),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(170.dp)
                    .height(320.dp)
                    .clickable(onClick = {
                        onMovieItemClick(movie)
                    })
                    .constrainAs(movieImage) {
                        top.linkTo(parent.bottom)
                    },
            )
            if (movie.avgVote > 7.00) {
                VxTrendingTopTextBanner(
                    modifier = Modifier.constrainAs(topRate) {
                        bottom.linkTo(movieImage.bottom, margin = 24.dp)
                        start.linkTo(parent.end)
                        end.linkTo(parent.end)
                    },
                    text = "Top",
                    rating = "10",
                    false,

                )
            }
        }
    }
}
