package com.hieu10.kotlinshop.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object VariantType {
    val CurrencyHighlight = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        color = Color(0xFFD4AF37)
    )

    val ChatbotMessage = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFF1A1C1E)
    )

    val ChatUserMessage = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color(0xFFFFFFFF)
    )

    val AdminAnalytics = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        color = Color(0xFF00A36C)
    )

    val ModeratorAlert = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        color = Color(0xFFD22B2B)
    )

    val SKUMono = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = Color(0xFF6E6E6E)
    )

    val TimestampThin = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        color = Color(0xFFA0A0A0)
    )
}