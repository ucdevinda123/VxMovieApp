package com.spore.vxmoviesapp.ui.components.appbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.spore.vxmoviesapp.ui.anim.getVxTopBarColorState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarHeightState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarWidthState

@Composable
fun VxAppBarWithBack(
    isScrollingDown: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    title: String,

) {
    Surface(
        modifier = modifier
            .padding(top = getVxTopBarWidthState(isScrolledDown = isScrollingDown).value)
            .height(getVxTopBarHeightState(isScrollingDown).value),
        color = getVxTopBarColorState(isScrolledDown = isScrollingDown).value,
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            TopAppBar(
                elevation = 0.dp,
                backgroundColor = Color.Transparent,
                modifier = Modifier.height(56.dp),
            ) {
                Column {
                    VxAppBarBackButton(navController, title)
                    Spacer(modifier = Modifier.height(10.dp))
                    AnimatedVisibility(visible = isScrollingDown.not()) {
                    }
                }
            }
        }
    }
}

@Composable
fun VxAppBarBackButton(
    navController: NavHostController,
    text: String,
) {
    Row(Modifier.padding(start = 16.dp, end = 16.dp)) {
        Box(
            modifier = Modifier
                .weight(2f)
                .align(Alignment.CenterVertically),
        ) {
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Text(
            text = text,
            textAlign = TextAlign.Left,
            maxLines = 1,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                shadow = Shadow(color = Color.White),
                fontSize = 19.sp,
                color = Color.White,
            ),
            modifier = Modifier
                .padding(5.dp)
                .weight(10f)
                .align(Alignment.CenterVertically)
                .clickable {
                },

        )
    }
}
