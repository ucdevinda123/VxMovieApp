package com.spore.vxmoviesapp.ui.components.menubar

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.spore.vxmoviesapp.R

@Composable
fun VxCategoryMenuBar(
    onCategoryTap: (String) -> Unit,
) {
    val context = LocalContext.current
    Row {
        VxMenuBarItem(
            text = stringResource(id = R.string.tv_shows),
            modifier = Modifier.weight(1f),
            onMenuItemTap = {
                onCategoryTap("TvShows")
            },
        )
        VxMenuBarItem(
            text = stringResource(id = R.string.movies),
            modifier = Modifier.weight(1f),
            onMenuItemTap = {
                onCategoryTap("Movies")
            },
        )
        VxMenuBarItem(
            text = stringResource(id = R.string.categories),
            modifier = Modifier.weight(1f),
            onMenuItemTap = {
                onCategoryTap("Categories")
            },
        )
    }
}
