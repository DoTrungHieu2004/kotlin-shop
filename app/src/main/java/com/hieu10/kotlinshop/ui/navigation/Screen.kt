package com.hieu10.kotlinshop.ui.navigation

sealed class Screen(val route: String) {
    // Auth group
    object AuthGraph : Screen("auth_graph")
    object Login : Screen("login")
    object Register : Screen("register")

    // User group
    object UserGraph : Screen("user_graph")
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Chatbot : Screen("chatbot")

    // Admin/mod group
    object AdminDashboard : Screen("admin_dashboard")
    object ModeratorDashboard : Screen("mod_dashboard")
}