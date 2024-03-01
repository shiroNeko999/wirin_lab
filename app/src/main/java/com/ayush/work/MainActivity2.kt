package com.ayush.work

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ayush.wirin_lab2.R


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


        }
    }
}

@Composable
fun BlackCardWithText(text1: String, text2:String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(11.dp)
            .background(Color.Black, shape = RoundedCornerShape(20))
            .padding(16.dp)

    ) {
        Column(modifier= Modifier
            .padding(5.dp)
            .fillMaxWidth(),

            verticalArrangement = Arrangement.spacedBy(20.dp)) {


        Text(
            text = text1,
            fontSize = 28.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier,
            letterSpacing = 0.8.sp,
            fontWeight = FontWeight.W600

        )
            Text(
                text = text2,
                fontFamily = FontFamily.SansSerif ,
                color = Color.White,
                fontSize = 17.sp,
                fontStyle= FontStyle.Italic

            )


        }
    }
}





@Composable
fun VerticalColumnOfBlackCards(cardTexts: List<String>, cardCaptions: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(1f),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(cardTexts.size) { index ->
            BlackCardWithText(text1 = cardTexts[index], text2= cardCaptions[index])
        }
    }
}


@Composable
fun PreviewVerticalColumnOfBlackCards(Drivemode:String, SongName:String, CarMode:String) {
    val sampleTexts = listOf("Vehicle Statistics", "Drive Mode", "Entertainment", "Car Mode")
    val sampleCaptions= listOf("View your vehicle statistics","Driver Mode: $Drivemode","Currently Playing: $SongName","Current: $CarMode")
    VerticalColumnOfBlackCards(cardTexts = sampleTexts, cardCaptions = sampleCaptions)
}

@Composable
fun RideEnjoy(modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.Ride))
    var isPlaying by remember {mutableStateOf(true) }
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
    Card(modifier = Modifier
        .fillMaxWidth()
        , shape= RoundedCornerShape(15)) {
        androidx.compose.foundation.layout.Row(modifier= Modifier
            .fillMaxWidth()
            .background(color = Color.Black), horizontalArrangement= Arrangement.SpaceEvenly) {
            LottieAnimation(composition = composition, modifier = Modifier
                .size(175.dp)
                .padding(10.dp), progress= {progress})
            Text(text = "Sit back, relax and Enjoy your ride", fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, fontSize = 27.sp, modifier= Modifier.padding(5.dp), color = Color.Magenta)

        }

    }
}

@Composable
fun compiling(){
    Column(modifier= Modifier
        .fillMaxWidth()
        .padding(3.dp), verticalArrangement=Arrangement.SpaceEvenly) {
        RideEnjoy(modifier =Modifier.fillMaxWidth().padding(20.dp))
        PreviewVerticalColumnOfBlackCards(Drivemode="Automatic", SongName="Channa Mereya by Arijit Singh", CarMode="Entertainment")

    }
}

@Preview(showBackground = true)
@Composable
fun Previewman(){
    compiling()
}