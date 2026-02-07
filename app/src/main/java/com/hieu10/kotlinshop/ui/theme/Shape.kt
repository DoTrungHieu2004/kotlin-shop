package com.hieu10.kotlinshop.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val AppShapes = Shapes(
    // Used for tooltips and small tags
    extraSmall = RoundedCornerShape(4.dp),

    // Used for buttons and text fields
    small = RoundedCornerShape(8.dp),

    // Used for product cards and search bars
    medium = RoundedCornerShape(16.dp),

    // Used for bottom sheets (card, filter) and large dialogs
    large = RoundedCornerShape(24.dp),

    // Used for the chatbot button or user avatars
    extraLarge = RoundedCornerShape(32.dp)
)