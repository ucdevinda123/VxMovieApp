package com.spore.vxmoviesapp.ui.components.appbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.spore.vxmoviesapp.data.network.constant.ApiConstant
import com.spore.vxmoviesapp.ui.anim.getVxTopBarColorState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarHeightState
import com.spore.vxmoviesapp.ui.anim.getVxTopBarWidthState


@Composable
fun VxAppBarWithBack(
    isScrollingDown: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    title:String

) {
    Surface(
        modifier = modifier
            .padding(top = getVxTopBarWidthState(isScrolledDown = isScrollingDown).value)
            .height(getVxTopBarHeightState(isScrollingDown).value),
        color = getVxTopBarColorState(isScrolledDown = isScrollingDown).value
    ) {
        Box(modifier= Modifier
            .fillMaxHeight()
            .fillMaxWidth()) {
            TopAppBar(
                elevation = 0.dp,
                backgroundColor = Color.Transparent,
                modifier = Modifier.height(40.dp)
            ) {
                Column {
                    VxAppBarBackButton(navController,title)
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
    text: String
) {
    Row(Modifier.padding(start = 1.dp)) {
        Box(
            modifier = Modifier
                .weight(2f)
                .align(Alignment.CenterVertically)
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
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
                color = Color.White
            ),
            modifier = Modifier
                .padding(5.dp)
                .weight(10f)
                .align(Alignment.CenterVertically)
                .clickable {

                }

        )
    }
}
