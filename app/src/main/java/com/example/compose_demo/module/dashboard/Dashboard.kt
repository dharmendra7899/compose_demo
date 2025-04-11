package com.example.compose_demo.module.dashboard

import android.net.http.SslCertificate.restoreState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            composable(Destinations.Home.route) { Text("home") }
            composable(Destinations.LatestJob.route) { Text("latest_job") }
            composable(Destinations.Category.route) { Text("category") }
            composable(Destinations.Setting.route) { Text("setting") }
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
    //val selectedItem = bottomNavController.currentBackStackEntryAsState().value?.destination?.route
    val selectedNavigationIndex = rememberSaveable { mutableIntStateOf(0) }
    NavigationBar {
        destinations.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                alwaysShowLabel = true,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    bottomNavController.navigate(item.route) {
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    item.icon?.let {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = item.label
                        )
                    }
                },
                label = {
                    Text(
                        item.label,
                        color = if (index == selectedNavigationIndex.intValue)
                            Color.Black
                        else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )
            )

        }
    }
}


