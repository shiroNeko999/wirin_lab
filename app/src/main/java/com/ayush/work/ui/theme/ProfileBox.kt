package com.ayush.work.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ayush.work.GradientBackgroundBrush
import com.ayush.work.R

@Composable
fun ProfileBox(userName: String, modifier: Modifier) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp).background(
            brush = GradientBackgroundBrush(
                isVerticalGradient = true,
                colors = listOf(


                    Color(0XFF1F1A5C),
                    Color(0xFF18162B),
                    Color(0XFF000000),
                )
            )
        ), elevation = 10.dp, backgroundColor = Color.Transparent, shape = RoundedCornerShape(8.dp)
    ) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            , horizontalArrangement = Arrangement.SpaceBetween

    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.useranimation))
        var isPlaying by remember { mutableStateOf(true) }
        isPlaying=true
        val progress by animateLottieCompositionAsState(composition = composition, isPlaying=isPlaying)
        LaunchedEffect(key1= progress){
            if(progress==0f){
                isPlaying=true
            }
            if(progress==1f){
                isPlaying=false
            }
        }
        // Profile Picture


        Column(modifier=Modifier.align(Alignment.Bottom).padding(8.dp)) {
            Spacer(modifier = Modifier.padding())
            Text(text = "Hello! \n$userName", color = Color.White, fontSize = 35.sp, fontFamily = FontFamily.SansSerif, fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.ExtraBold)


        }

        Box(
            modifier = Modifier
                .size(128.dp)

        ) {
            LottieAnimation(composition = composition, modifier = Modifier
                .size(175.dp)
                .padding(2.dp), progress= {progress})
        }



    }}
}

@Preview(showBackground = true)
@Composable
fun letstry1(){
    var hey=0
    ProfileBox("Ashutosh", Modifier.padding(16.dp))
}