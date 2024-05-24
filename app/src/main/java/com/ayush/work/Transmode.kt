package com.ayush.work

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Transmode(){
    val gradientColors  = listOf(


        Color(0xFF000000),     // 100% - Color(0xFF000000)
        Color(0xFF05040E),     // 87%  - Color(0xFF05040E)
        Color(0xFF1F1A5C)      // 99%  - Color(0xFF1F1A5C)
    )
    Box(contentAlignment = Alignment.BottomEnd
        ,modifier= Modifier.background(
        brush = GradientBackgroundBrush(
            isVerticalGradient = false,
            colors = gradientColors
        ))){
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)

            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier=Modifier.height(18.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color.DarkGray.copy(alpha = 0.4f),
                elevation = 50.dp,
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Select\nDriving Mode",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 45.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(14.dp)
                        .align(Alignment.Start)
                )
            }

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
            ButtonRow()
            Spacer(modifier=Modifier.height(24.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color.DarkGray.copy(alpha = 0.4f),
                elevation = 50.dp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ){
                GoogleMapsScreen()
            }
        }}}
@Composable
fun ButtonRow() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        AnimatedButton(
            text = "Manual",
            gradientColors = listOf(Color(0xFFA83232), Color(0xFFD46A6A), Color(0xFFA83232))
        )
        AnimatedButton(
            text = "Automatic",
            gradientColors = listOf(Color(0xFF324BA8), Color(0xFF6A86D4), Color(0xFF324BA8))
        )
    }
}

@Composable
fun AnimatedButton(text: String, gradientColors: List<Color>) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = tween(durationMillis = 100)
    )

    Button(
        onClick = { isPressed = !isPressed },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor =  Color.Transparent),
        elevation = ButtonDefaults.elevation(defaultElevation = 50.dp),
        modifier = Modifier
            .scale(scale)
            .background(
                Brush.linearGradient(colors = gradientColors),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Text(
            text = text,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(10.dp)

        )
    }
}
@Preview(showBackground = true)
@Composable
fun Transmodelol(){
    Transmode()
}
@Composable
fun CircularFAB(onClick: () -> Unit, text: String) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier.size(56.dp), // Standard size for FAB
        backgroundColor = Color.Transparent,
        contentColor = Color.White
    ) {
        Text(
            text = text,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(10.dp)

        )
    }
}