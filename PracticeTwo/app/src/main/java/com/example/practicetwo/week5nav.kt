package com.example.practicetwo

import android.os.Bundle
import androidx.activity.ComponentActivity
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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class week5nav : ComponentActivity() {
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
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        NavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
    }

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
fun BottomBar(navController: NavHostController){
val screens = listOf(View.Home, View.FavoriteMovies, View.Settings)

    NavigationBar {
        NavigationBarItem (
        icon = { Icon(View.Home.icon, contentDescription = View.Home.title)},
        label = { Text(View.Home.title)},
        selected = true,
        onClick = {
            navController.navigate(View.Home.route) {

            }
        }
        )

    }
}
@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier) {

    NavHost(navController, startDestination = View.Home.route, modifier = Modifier) {
        composable(View.Home.route) {
            Home()
        }
    }

}