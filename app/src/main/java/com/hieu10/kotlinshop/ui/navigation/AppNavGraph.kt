package com.hieu10.kotlinshop.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hieu10.kotlinshop.di.ServiceLocator
import com.hieu10.kotlinshop.viewmodel.AuthViewModel
import com.hieu10.kotlinshop.viewmodel.factory.AuthVMFactory

@Composable
fun AppNavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel = viewModel(factory = AuthVMFactory(ServiceLocator.authRepository))
) {
    // Observe authentication state
    val userToken by authViewModel.userToken.collectAsState()

    NavHost(
        navController = navController,
        // Start at Auth if no token, else go to User (Role-check logic can expand here)
        startDestination = if (userToken == null) {
            Screen.AuthGraph.route
        } else {
            Screen.UserGraph.route
        }
    ) {
        // --- BOTTOM NAVIGATION GRAPH ---
        composable(BottomNavItem.Home.route) {
            // TODO: Home screen place here
        }
        composable(BottomNavItem.Search.route) {
            // TODO: Search screen place here
        }
        composable(BottomNavItem.Cart.route) {
            // TODO: Cart screen place here
        }
        composable(BottomNavItem.Profile.route) {
            // TODO: Profile screen place here
        }

        // --- AUTHENTICATION NESTED GRAPH ---
        navigation(
            startDestination = Screen.Login.route,
            route = Screen.AuthGraph.route
        ) {
            composable(Screen.Login.route) {
                // TODO: Login screen place here
            }
            composable(Screen.Register.route) {
                // TODO: Register screen place here
            }
        }

        // --- USER NESTED GRAPH ---
        navigation(
            startDestination = Screen.Home.route,
            route = Screen.UserGraph.route
        ) {
            composable(Screen.Home.route) {
                // TODO: Home screen place here
            }
            composable(Screen.Cart.route) {
                // TODO: Cart screen place here
            }
            composable(Screen.Chatbot.route) {
                // TODO: Chatbot screen place here
            }
        }

        // --- ADMIN & MODERATOR ROUTES ---
        composable(Screen.AdminDashboard.route) {
            // TODO: Admin dashboard screen place here
        }
        composable(Screen.ModeratorDashboard.route) {
            // TODO: Moderator dashboard screen place here
        }
    }
}