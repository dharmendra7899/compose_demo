package com.example.compose_demo.navigation
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
    data object Home : Destinations("home", "Home", icon = R.drawable.ic_bottom_home)
    data object LatestJob : Destinations("latest_job", "Latest Job", icon = R.drawable.ic_bottom_latest)
    data object Category : Destinations("category", "Category", icon = R.drawable.ic_bottom_category)
    data object Setting : Destinations("setting", "Setting", icon = R.drawable.ic_bottom_settings)

}



