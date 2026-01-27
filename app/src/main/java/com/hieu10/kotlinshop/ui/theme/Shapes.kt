package com.hieu10.kotlinshop.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    // Main auth cards, Chat sheets
    extraLarge = RoundedCornerShape(28.dp),

    // Main shopping grid items
    large = RoundedCornerShape(16.dp),

    // Primary actions
    medium = RoundedCornerShape(12.dp),

    // Text fields and filter chips
    small = RoundedCornerShape(8.dp)
)