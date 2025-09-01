package com.spore.vxmoviesapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
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
    onSearchItemTap: ()->Unit,
    onMyListItemTap: ()->Unit
) {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(6f)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(id = R.drawable.vx_icon_im),
                contentDescription = "App Bar",
                modifier = Modifier
                    .height(32.dp)
                    .clickable {}
            )
        }
        
        IconButton(
            onClick = { onSearchItemTap() },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(
            onClick = { onMyListItemTap() },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.List,
                contentDescription = "My List",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
