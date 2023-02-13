package com.spore.vxmoviesapp.ui.components.carousal

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.ui.components.imageholders.VxLargeMovieItem
import com.spore.vxmoviesapp.ui.components.imageholders.VxSmallMovieItem


@Composable
fun VxMovieCarousal(
    title: String,
    pagingData: LazyPagingItems<Movie>,
    usLargeImageItem: Boolean,
    onItemClick:(id:Long) -> Unit
) {
    Column(modifier = Modifier.padding(5.dp)) {
        Row(Modifier.fillMaxWidth()) {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                ),
                color = Color.White,
                modifier = Modifier
                    .padding(start = 12.dp, top = 4.dp)
                    .weight(2f)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))
        LazyRow(modifier = Modifier.padding(8.dp)) {
            items(pagingData) {
                if (it != null) {
                    if (usLargeImageItem) {
                        VxLargeMovieItem(it, onMovieItemClick = { movieItem ->
                            onItemClick(movieItem.id)
                        })
                    } else {
                        VxSmallMovieItem(it, onMovieSelected = {
                            onItemClick(it)
                        }, Modifier.padding(4.dp))
                    }
                }
            }
        }
    }
}