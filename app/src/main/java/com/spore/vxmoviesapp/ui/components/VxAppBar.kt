package com.spore.vxmoviesapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.spore.vxmoviesapp.R

@Composable
fun VxAppBar(
    onSearchItemTap: ()->Unit
) {
    Row(Modifier.padding(start = 8.dp)) {
        Box(
            modifier = Modifier
                .weight(6f)
                .align(Alignment.CenterVertically)
        ) {
            Image(painter = painterResource(
                id = R.drawable.vx_icon_im
            ),
                contentDescription = "App Bar",
                modifier = Modifier
                    .height(30.dp)
                    .clickable {}
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .clickable {
                    onSearchItemTap()
                }
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                tint = Color.White
            )
        }

        Box(modifier = Modifier
            .weight(1f)
            .clickable { }
        ) {
            Icon(
                imageVector = Icons.Outlined.List,
                contentDescription = " My List",
                tint = Color.White
            )
        }
    }
}
