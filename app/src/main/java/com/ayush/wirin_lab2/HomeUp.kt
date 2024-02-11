package com.ayush.wirin_lab2

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun HomeUp() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0XFF212121))
    )

        Column() {
            Row(modifier = Modifier.padding(6.dp)) {
               Icon(painter = painterResource(id = R.drawable.ic_outline_electric_car_24), contentDescription ="Car",modifier = Modifier.padding(0.dp) )
                Text(text = "365 km", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold,color = Color(0XFF818181), modifier = Modifier.padding(10.dp,0.dp))

            }
            Text(text = "Parked", color = Color(0XFF818181), modifier = Modifier.padding(10.dp,2.dp), fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.tesla3), contentDescription ="Car image",
                modifier = Modifier
                    .padding(60.dp, 10.dp)
                    .fillMaxWidth(0.85f)
            )

        }
    }


