package com.spore.vxmoviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spore.vxmoviesapp.ui.screen.VxMainViewContainer
import com.spore.vxmoviesapp.ui.theme.VxMovieAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VxMovieAppTheme(darkTheme = true) {
                VxMainViewContainer()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VxMovieAppTheme(darkTheme = true) {
        VxMainViewContainer()
    }
}