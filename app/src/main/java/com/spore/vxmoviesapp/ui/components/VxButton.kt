package com.spore.vxmoviesapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VxRoundedButton(text: String, modifier: Modifier = Modifier,withBorder: Boolean = false, onClick : () -> Unit){
    Button(
        shape= CircleShape,
        elevation= ButtonDefaults.elevation(0.dp,0.dp),
        contentPadding= PaddingValues(8.dp,5.dp),
        modifier = modifier,
        onClick = { onClick },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
        border = BorderStroke(0.1.dp, Color.LightGray),
    ) {
        Text(text = text, color = Color.White)
    }
}