package com.spore.vxmoviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.spore.vxmoviesapp.ui.navigation.SetUpNavGraph
import com.spore.vxmoviesapp.ui.screen.VxMovieHome
import com.spore.vxmoviesapp.ui.theme.VxMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController:NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            VxMovieAppTheme(darkTheme = true) {
                SetUpNavGraph( navController = navController)
               // VxMovieHome()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VxMovieAppTheme(darkTheme = true) {
        //VxMovieHome(null)
    }
}