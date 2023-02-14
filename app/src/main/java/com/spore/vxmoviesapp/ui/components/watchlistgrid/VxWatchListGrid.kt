package com.spore.vxmoviesapp.ui.components.watchlistgrid

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spore.vxmoviesapp.data.offline.entity.MyList
import com.spore.vxmoviesapp.ui.components.imageholders.VxOfflineSmallMovieItem


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VxWatchListGrid(
    title: String,
    myListData: List<MyList>,
    gridSpan: Int,
    onItemClick: (id: Long) -> Unit
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

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            cells = GridCells.Fixed(gridSpan),
            content = {
                items(myListData.size) { index ->
                    myListData[index].let { myList ->
                        VxOfflineSmallMovieItem(myList, onMovieSelected = {
                            onItemClick(myList.mediaId)
                        }, Modifier.padding(4.dp))
                    }
                }
            }
        )

    }
}