package com.ayush.work

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class ColorGradient : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
@Composable
fun background(){
    val gradientColors  = listOf(


        Color(0XFF1F1A5C),
        Color(0x8705040E),
        Color(0XFF000000),
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = GradientBackgroundBrush(
                isVerticalGradient = true,
                colors = gradientColors
            )
        )
    )

}
@Composable
fun theme(){
    val gradientColors = listOf(
        Color(0XFF200D40),
        Color(0X876037A2)
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = GradientBackgroundBrush(
                isVerticalGradient = true,
                colors = gradientColors
            )
        ))
}

@Composable
fun GradientBackgroundBrush(
    isVerticalGradient: Boolean,
    colors: List<Color>
): Brush {
    val endOffset = if(isVerticalGradient){
        Offset(0f,Float.POSITIVE_INFINITY)
    }
    else{
        Offset(Float.POSITIVE_INFINITY,0f)
    }
    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = endOffset
    )
}
@Preview
@Composable
fun vv() {

    background()

}