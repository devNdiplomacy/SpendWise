package com.devndiplomacy.spendwise.commonUi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.zIndex

/**
 * A reusable background component with a curved green top half and white bottom half.
 * @param content The content to display on top of the background
 */
@Composable
fun SpendWiseBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {

    val greenColor = Color(0xFF438883)
    val whiteColor = Color.White

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val width = constraints.maxWidth.toFloat()
        val height = constraints.maxHeight.toFloat()
        val greenHeight = height * 0.3f  // Green takes 40% of screen height

        // White background for the entire screen
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    drawRect(whiteColor)
                }
                .zIndex(0f)
        )

        // Green background with curved bottom
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    val path = Path().apply {
                        // Start at the top-left corner
                        moveTo(0f, 0f)
                        // Draw line to top-right corner
                        lineTo(width, 0f)
                        // Draw line to middle-right side
                        lineTo(width, greenHeight)

                        // Draw the curved bottom
                        cubicTo(
                            x1 = width * 0.75f, y1 = greenHeight + 60f,
                            x2 = width * 0.25f, y2 = greenHeight + 60f,
                            x3 = 0f, y3 = greenHeight
                        )

                        // Close the path
                        close()
                    }

                    drawPath(path, greenColor)
                }
                .zIndex(1f)
        )

        // Content container
        Box(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(2f)
        ) {
            content()
        }
    }
}