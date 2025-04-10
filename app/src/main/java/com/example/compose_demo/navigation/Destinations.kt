package com.example.compose_demo.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @Created by dharmendra Kumar on 10-04-2025.
 * Custom Navigation Graph
 */
sealed class Destinations(val route: String, val label: String, val icon: ImageVector? = null) {


    //Auth
    data object Login : Destinations("login", "Login")
    data object SignUp : Destinations("signUp", "Sign Up")
    data object ForgotPassword : Destinations("forgot_password", "Forgot Password")

    //Drawer
    data object Help : Destinations("help", "Help", Icons.Default.Face)
    data object Settings : Destinations("settings", "Settings", Icons.Default.Settings)

    // BottomAppBar Destinations
    data object Dashboard : Destinations("dashboard", "Dashboard")
    data object Home : Destinations("home", "Home", Icons.Default.Home)
    data object Search : Destinations("search", "Search", Icons.Default.Search)
    data object Profile : Destinations("profile", "Profile", Icons.Default.Person)

}



