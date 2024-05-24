package com.ayush.work

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(){
    val gradientColors  = listOf(


        Color(0xFF000000),     // 100% - Color(0xFF000000)
        Color(0xFF05040E),     // 87%  - Color(0xFF05040E)
        Color(0xFF1F1A5C)      // 99%  - Color(0xFF1F1A5C)
    )
    Box(modifier= Modifier.background(
        brush = GradientBackgroundBrush(
            isVerticalGradient = false,
            colors = gradientColors
        ))){
        Column(
            modifier = Modifier
                .fillMaxSize()

                ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier=Modifier.height(18.dp))
            Text(
                text = "Welcome\nAyush Vats",
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 45.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(14.dp)
                    .align(Alignment.Start)
            )
            Spacer(modifier=Modifier.height(24.dp))
            HomeUp()

            val shinyGradient = Brush.linearGradient(
                colors = listOf(

                    Color(0xFF474747),
                    Color(0xFF303030),
                    Color(0xFF000000)
                )
            )
            Spacer(modifier=Modifier.height(24.dp))
            Button(
                onClick = { /* Do something when button is clicked */ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(shinyGradient, shape = RoundedCornerShape(20.dp)),
                elevation = ButtonDefaults.elevation(50.dp)
            ) {
                Text(
                    text = "Start",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(10.dp)

                )
            }
        }}}

@Preview(showBackground = true)
@Composable
fun Welcomescreenlol(){
    WelcomeScreen()
}
