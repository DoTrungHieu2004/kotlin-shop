package com.hieu10.kotlinshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hieu10.kotlinshop.di.ServiceLocator
import com.hieu10.kotlinshop.ui.components.common.BottomBar
import com.hieu10.kotlinshop.ui.navigation.AppNavGraph
import com.hieu10.kotlinshop.ui.navigation.BottomNavItem
import com.hieu10.kotlinshop.ui.theme.KotlinShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ServiceLocator with context
        ServiceLocator.init(this)

        enableEdgeToEdge()
        setContent {
            KotlinShopTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                // Determine if we should show bottom bar
                val showBottomBar = when (currentRoute) {
                    BottomNavItem.Home.route,
                    BottomNavItem.Search.route,
                    BottomNavItem.Cart.route,
                    BottomNavItem.Profile.route -> true
                    else -> false
                }

                Scaffold(
                    bottomBar = {
                        if (showBottomBar) BottomBar(navController)
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}