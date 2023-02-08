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
        targetValue = if (isScrolledDown) 0.dp else 10.dp,
    )
}

@Composable
fun getVxTopBarHeightState(isScrolledDown: Boolean): State<Dp> {
    return animateDpAsState(
        targetValue = if (isScrolledDown) 40.dp else 80.dp,
    )
}

@Composable
fun getVxTopBarColorState(isScrolledDown: Boolean): State<Color> {
    return animateColorAsState(
        targetValue = if (isScrolledDown) Color.Black.copy(alpha = 0.6f) else Color.Transparent,
    )
}