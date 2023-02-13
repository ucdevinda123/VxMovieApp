package com.spore.vxmoviesapp.ui.components.imageholders

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.ui.components.VxRoundedImage
import com.spore.vxmoviesapp.ui.components.VxTrendingTopTextBanner

@Composable
fun VxSmallMovieItem(
    movie: Movie,
    onMovieSelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout {
        val (movieImage, topTrendingBanner) = createRefs()
        VxRoundedImage(
            imageUrl = movie.posterUrl,
            modifier = modifier
                .width(110.dp)
                .height(150.dp)
                .clickable(onClick = {
                    onMovieSelected(movie.id)
                })
                .constrainAs(movieImage) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
            cornerPercent = 3
        )
        if (movie.avgVote >= 8) {
            VxTrendingTopTextBanner(
                modifier = modifier.constrainAs(topTrendingBanner) {
                    top.linkTo(movieImage.top)
                    end.linkTo(movieImage.end)
                },
                "Top",
                "10",
                enableTitle = false
            )
        }
    }
}
