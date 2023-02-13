package com.spore.vxmoviesapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VxMenuBarItem(
    text: String,
    modifier: Modifier,
    onMenuItemTap: (type: String) -> Unit
) {

    Text(
        text = text,
        textAlign = TextAlign.Center,
        maxLines = 1,
        style = TextStyle(
            fontWeight = FontWeight.Medium,
            shadow = Shadow(color = Color.White),
            fontSize = 16.sp,
            color = Color.White
        ),
        modifier = modifier
            .padding(5.dp)
            .clickable {
                onMenuItemTap(text)
            }

    )
}