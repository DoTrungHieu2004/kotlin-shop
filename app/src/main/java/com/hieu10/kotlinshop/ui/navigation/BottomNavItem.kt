package com.hieu10.kotlinshop.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home_screen", Icons.Default.Home, "Home")
    object Search : BottomNavItem("search_screen", Icons.Default.Search, "Explore")
    object Cart : BottomNavItem("cart_screen", Icons.Default.ShoppingCart, "Cart")
    object Profile : BottomNavItem("profile_screen", Icons.Default.Person, "Account")
}