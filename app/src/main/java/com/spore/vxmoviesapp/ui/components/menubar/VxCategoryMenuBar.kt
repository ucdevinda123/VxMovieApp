package com.spore.vxmoviesapp.ui.components.menubar

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.spore.vxmoviesapp.R
import com.spore.vxmoviesapp.ui.components.VxMenuBarItem

@Composable
fun VxCategoryMenuBar(
  modifier: Modifier = Modifier
) {
    Row {
        VxMenuBarItem(
            text = stringResource(id = R.string.tv_shows),
            modifier = Modifier.weight(1f),
            onMenuItemTap = {

            }
        )
        VxMenuBarItem(
            text = stringResource(id = R.string.movies),
            modifier = Modifier.weight(1f),
            onMenuItemTap = {

            })
        VxMenuBarItem(
            text = stringResource(id = R.string.categories),
            modifier = Modifier.weight(1f),
            onMenuItemTap = {

            })
    }
}