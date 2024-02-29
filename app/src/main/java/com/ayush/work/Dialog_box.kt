package com.ayush.work

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Dialog_box(parameter: String, description: String, value:String )
{



    Box(
        modifier = Modifier.background(
            color = Color(0xC8381253), shape = RoundedCornerShape(20.dp)

        )

    ){
        Column (modifier = Modifier){
            Row {
                IconButton(onClick ={} ) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_electric_bolt_24), contentDescription = "brake level",modifier = Modifier.padding(0.dp)
                        .size(24.dp), tint = Color.White)

                }
                Text(text = parameter, modifier = Modifier.padding(10.dp) ,style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Monospace, color = Color.White), )
            }

            Text(modifier = Modifier.padding(10.dp),
                text = "Current parameter is :$value",
                style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W200, color = Color.White
                ))

            Text(modifier = Modifier.padding(10.dp),
                text = description,
                style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W200, color = Color.White
                ))
        }

    }
}

@Preview
@Composable
fun vvv ()
{
    Dialog_box("B R A K E   L E V E L ",
        "The brake level can vary from 0 to 300 varying on the intensity of the brake applied","300")
}
