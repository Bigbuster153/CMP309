package com.example.practicetwo
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class View(val route: String, val title: String, val icon: ImageVector) {

    object Home:View("home", "Home", Icons.Filled.Home)
    object FavoriteMovies: View("movies", "Fav Movies", Icons.Filled.Person)
    object Settings: View("settings", "Settings", Icons.Filled.Settings)

}