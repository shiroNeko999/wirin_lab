package com.ayush.work

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Controls_page()
{var context = LocalContext.current
    Card(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF030101))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Control Unit Status",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "LIGHT", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF000000))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Control Settings",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "SEAT", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF000000))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Vehicle Status",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "SUMMON", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF090606))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Vehicle Status",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Steer", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF0A0505))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Vehicle Status",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Music", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF050202))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Vehicle Status",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Advanced Controls", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
}