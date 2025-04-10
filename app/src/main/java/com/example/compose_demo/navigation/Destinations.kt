package com.example.compose_demo.navigation


import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.compose_demo.R

/**
 * @Created by dharmendra Kumar on 10-04-2025.
 * Custom Navigation Graph
 */
sealed class Destinations(val route: String, val label: String, val icon: Int? = null,) {


    //Auth
    data object Login : Destinations("login", "Login")
    data object SignUp : Destinations("signUp", "Sign Up")
    data object ForgotPassword : Destinations("forgot_password", "Forgot Password")



    //BottomAppBar Destinations
    data object Dashboard : Destinations("dashboard", "Dashboard")
    data object Home : Destinations("home", "Home", icon = R.drawable.home)
    data object LatestJob : Destinations("latest_job", "Latest Job", icon = R.drawable.job)
    data object Category : Destinations("category", "Category", icon = R.drawable.category)
    data object Setting : Destinations("setting", "Setting", icon = R.drawable.setting)

}



