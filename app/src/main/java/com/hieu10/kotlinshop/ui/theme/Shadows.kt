package com.hieu10.kotlinshop.ui.theme

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Shadows {
    // Subtle lift for product cards
    val CardElevation = 4.dp

    // Strong lift for floating chat buttons or mod alerts
    val HighElevation = 12.dp

    // Custom Shadow modifier for a "Soft Glow" effect on buttons
    fun Modifier.softGlow(
        color: Color = Color.Black.copy(alpha = 0.08f),
        borderRadius: Dp = 12.dp,
        blurRadius: Dp = 8.dp,
        offsetY: Dp = 4.dp
    ) = this.drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter = (BlurMaskFilter(
                    blurRadius.toPx(),
                    BlurMaskFilter.Blur.NORMAL
                ))
            }
            frameworkPaint.color = color.toArgb()

            val left = 0f
            val top = offsetY.toPx()
            val right = size.width
            val bottom = size.height + offsetY.toPx()

            canvas.drawRoundRect(
                left = left,
                top = top,
                right = right,
                bottom = bottom,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint = paint
            )
        }
    }
}