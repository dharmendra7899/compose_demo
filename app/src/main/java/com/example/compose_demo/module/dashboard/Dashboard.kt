package com.example.compose_demo.module.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose_demo.navigation.Destinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardPage(mainNavController: NavHostController) {
    val bottomNavController = rememberNavController()
    val scope = rememberCoroutineScope()
    Scaffold(

        bottomBar = {
            BottomAppBar { BottomNavigationBar(bottomNavController = bottomNavController) }

        })
    {
        NavHost(
            bottomNavController,
            startDestination = Destinations.Home.route,
            Modifier.padding(it)
        ) {
            composable(Destinations.Home.route) { Text("Home") }
            composable(Destinations.LatestJob.route) { Text("Latest Job") }
            composable(Destinations.Category.route) { Text("Category") }
            composable(Destinations.Setting.route) { Text("Setting") }
        }


    }
}

@Composable
fun BottomNavigationBar(bottomNavController: NavHostController) {
    val destinations = listOf(
        Destinations.Home,
        Destinations.LatestJob,
        Destinations.Category,
        Destinations.Setting
    )
    val selectedItem = bottomNavController.currentBackStackEntryAsState().value?.destination?.route
    NavigationBar {
        destinations.forEach { item ->
            NavigationBarItem(
                alwaysShowLabel = true,
                icon = {
                    item.icon?.let { resId ->
                        val icon: Painter = painterResource(id = resId)
                        Icon(icon, contentDescription = item.label)
                    }
                },
                ///if want to use Icon the use this
                // icon = { item.icon?.let { Icon(it, contentDescription = item.label) } },
                label = { Text(item.label) },
                selected = selectedItem == item.route,
                onClick = {
                    bottomNavController.navigate(item.route) {
                        bottomNavController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}