package com.App.tiktok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.App.tiktok.ui.components.BottomNavigationBar  // Import your BottomNavigationBar
import com.App.tiktok.ui.screens.*
import com.App.tiktok.ui.theme.TikTokCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TikTokCloneTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            if (navController.currentBackStackEntryAsState().value?.destination?.route != "login") {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "login", modifier = Modifier.padding(innerPadding)) {
            composable("login") {
                LoginScreen(onLoginClick = {
                    navController.navigate("home")
                })
            }
            composable("home") {
                HomeScreen()
            }
            composable("discover") {
                DiscoverScreen()
            }
            composable("add_video") {
                AddVideoScreen()
            }
            composable("inbox") {
                InboxScreen()
            }
            composable("profile") {
                ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TikTokCloneTheme {
        val navController = rememberNavController()
        AppNavigation(navController = navController)
    }
}
