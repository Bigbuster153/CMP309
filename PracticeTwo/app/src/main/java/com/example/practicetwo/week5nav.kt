package com.example.practicetwo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicetwo.ui.theme.SadTheme
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

class week5nav : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SadTheme {
                MainView()
            }
        }
    }
}

@Composable
fun MainView(){

}
@Composable
fun Home(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment =
    Alignment.Center) {
        Text(
            text = "Home"
        )
    }
}
@Composable
fun FavoriteMovies(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment =
    Alignment.Center) {
        Text(
            text = "Favourite Movies"
        )
    }
}
@Composable
fun SettingScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment =
    Alignment.Center) {
        Text(
            text = "Settings"
        )
    }
}

@Composable
fun BottomBar(NavController: NavHostController){

}
@Composable
fun NavGraph(NavHostController: NavHostController, Modifier: Modifier) {

}