package com.spore.vxmoviesapp.ui.components.searchgrid

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.spore.vxmoviesapp.domain.model.Movie
import com.spore.vxmoviesapp.ui.components.imageholders.VxSmallMovieItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VxMovieGrid(
    title: String,
    pagingData: LazyPagingItems<Movie>,
    gridSpan: Int,
    onItemClick: (id: Long) -> Unit,
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
                    .weight(2f),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(gridSpan),
            content = {
                items(pagingData.itemCount) { index ->
                    pagingData[index]?.let {
                        VxSmallMovieItem(it, onMovieSelected = {
                            onItemClick(it)
                        }, Modifier.padding(4.dp))
                    }
                }
            },
        )
    }
}
