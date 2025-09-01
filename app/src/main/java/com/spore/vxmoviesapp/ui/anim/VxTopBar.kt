package com.spore.vxmoviesapp.ui.anim

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getVxTopBarWidthState(isScrolledDown: Boolean): State<Dp> {
    return animateDpAsState(
        targetValue = if (isScrolledDown) 0.dp else 16.dp,
    )
}

@Composable
fun getVxTopBarHeightState(isScrolledDown: Boolean): State<Dp> {
    return animateDpAsState(
        targetValue = if (isScrolledDown) 56.dp else 120.dp,
    )
}

@Composable
fun getVxTopBarColorState(isScrolledDown: Boolean): State<Color> {
    return animateColorAsState(
        targetValue = if (isScrolledDown) Color.Black.copy(alpha = 0.8f) else Color.Transparent,
    )
}
