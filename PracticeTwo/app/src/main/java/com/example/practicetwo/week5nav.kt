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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
    ) {
        NavGraph(navController = navController)

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
    val navBackStackEntry by navController.currentBackStackEntryAsState() //checks for changes in the backstack
    val currentRoute = navBackStackEntry?.destination?.route //gets the route of the current destination

    NavigationBar {
        //3 items, one for each button
        screens.forEach{ View ->
            NavigationBarItem(
                icon = { Icon(View.icon, contentDescription = View.title) },
                label = { Text(View.title) },
                selected = currentRoute == View.route,
                onClick = {
                    navController.navigate(View.route) {
                        //so it doesn't create multiple instances of the same screen when clicked multiple times
                        launchSingleTop = true
                    }
                }
            )
        }

    }
}
@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController, startDestination = Screen.Home.route) {
        //when given that path, it will change the view to this function
        composable(View.Home.route) {
            Home()
        }
        composable(View.FavoriteMovies.route) {
            FavoriteMovies()
            UserManagement(
                listOf(
                    "Iron Man",
                    "Snatch",
                    "Forrest Gump",
                    "Cars",
                    "Fast and Furious"
                )
            )
        }
        composable(View.Settings.route) {
            SettingScreen()
        }
    }

}