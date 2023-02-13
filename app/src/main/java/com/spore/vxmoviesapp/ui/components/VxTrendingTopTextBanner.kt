package com.spore.vxmoviesapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VxTrendingTopTextBanner(
    modifier: Modifier,
    text: String,
    rating: String,
    enableTitle: Boolean
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            color = Color.Red,
            shape = RoundedCornerShape(10),
            modifier = modifier
                .size(28.dp, 28.dp)
                .padding(2.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = text,
                    fontSize = 6.sp,
                    style = MaterialTheme.typography.button,
                    maxLines = 1
                )

                Text(
                    text = rating,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.button,
                    maxLines = 1
                )
            }
        }
        if (enableTitle) {
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "1# In Movies Today",
                fontSize = 14.sp,
                letterSpacing = (-0.10).sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.button,
                maxLines = 1
            )
        }

    }
}
