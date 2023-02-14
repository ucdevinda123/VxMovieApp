package com.spore.vxmoviesapp.ui.components.imageholders

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.spore.vxmoviesapp.data.offline.entity.MyList
import com.spore.vxmoviesapp.ui.components.VxRoundedImage

@Composable
fun VxOfflineSmallMovieItem(
    movie: MyList,
    onMovieSelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout {
        val (movieImage) = createRefs()
        movie.imagePath?.let {
            VxRoundedImage(
                imageUrl = it,
                modifier = modifier
                    .width(110.dp)
                    .height(150.dp)
                    .clickable(onClick = {
                        onMovieSelected(movie.mediaId)
                    })
                    .constrainAs(movieImage) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    },
                cornerPercent = 3
            )
        }
    }
}
