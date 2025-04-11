package com.example.compose_demo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost as ComposeNavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.compose_demo.module.auth.ForgotPassword
import com.example.compose_demo.module.auth.LoginPage
import com.example.compose_demo.module.auth.RegisterPage
import com.example.compose_demo.module.dashboard.CategoryPage
import com.example.compose_demo.module.dashboard.DashboardPage
import com.example.compose_demo.module.dashboard.HomePage
import com.example.compose_demo.module.dashboard.LatestJobPage
import com.example.compose_demo.module.dashboard.SettingPage


@Composable
fun MainNavGraph(modifier: Modifier = Modifier) {
    val mainNavController = rememberNavController()

    ComposeNavHost(
        navController = mainNavController,
        modifier = modifier,
        startDestination = Destinations.Login.route
    ) {
        composable(Destinations.Login.route) { LoginPage(navController = mainNavController) }
        composable(Destinations.SignUp.route) { RegisterPage(navController = mainNavController) }
        composable(Destinations.ForgotPassword.route) { ForgotPassword(navController = mainNavController) }
        composable(Destinations.Dashboard.route) { DashboardPage(mainNavController) }
        composable(Destinations.Home.route) { HomePage() }
        composable(Destinations.Category.route) { CategoryPage() }
        composable(Destinations.LatestJob.route) { LatestJobPage() }
        composable(Destinations.Setting.route) { SettingPage() }
    }
}

