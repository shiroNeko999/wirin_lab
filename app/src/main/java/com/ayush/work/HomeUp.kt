package com.ayush.work

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeUp() {
    val gradientColors  = listOf(


        Color(0xFF000000),     // 100% - Color(0xFF000000)
        Color(0xFF05040E),     // 87%  - Color(0xFF05040E)
        Color(0xFF1F1A5C)      // 99%  - Color(0xFF1F1A5C)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue

                )
            )



        Column(modifier = Modifier.fillMaxWidth().background( brush = GradientBackgroundBrush(
            isVerticalGradient = false,
            colors = gradientColors))) {
            Row(modifier = Modifier.padding(6.dp)) {
               Icon(painter = painterResource(id = R.drawable.car), contentDescription ="Car",modifier = Modifier.padding(0.dp).size(24.dp),  tint = Color.Unspecified
               )
                Text(text = "365 km", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold,color = Color.White, modifier = Modifier.padding(10.dp,0.dp))

            }
            Text(text = "Parked", color = Color.White, modifier = Modifier.padding(10.dp,2.dp), fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.tesla3), contentDescription ="Car image",
                modifier = Modifier
                    .padding(60.dp, 10.dp)
                    .fillMaxWidth(0.85f)
            )

        }
    }

@Preview
@Composable
fun mvp()
{
    HomeUp()
}


