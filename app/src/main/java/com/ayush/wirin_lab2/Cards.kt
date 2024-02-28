package com.ayush.wirin_lab2

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Cards()
{var context = LocalContext.current

    Card(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()
            .padding(5.dp)
            .background(color = Color(0XFF281E4D)),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0XFF281E4D))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Control Unit Status",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Control Unit Status", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

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
        Row(modifier = Modifier.background(color = Color(0XFF818181))) {
            Icon(
                painter = painterResource(id = R.drawable.car),
                contentDescription = "Control Settings",
                modifier = Modifier.padding(5.dp).size(24.dp), tint = Color.Unspecified
            )
            Text(
                color = Color.White, text = "Control Settings", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

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
        Row(modifier = Modifier.background(color = Color(0XFF818181))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Vehicle Status",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Vehicle Status", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

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
        Row(modifier = Modifier.background(color = Color(0XFF818181))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Table Status",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Table Status", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

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
        Row(modifier = Modifier.background(color = Color(0XFF818181))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Controls",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "HVAC", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

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
        Row(modifier = Modifier.background(color = Color(0XFF818181))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Controls",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Tyre", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

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
        Row(modifier = Modifier.background(color = Color(0XFF818181))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Controls",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "OBC", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

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
        Row(modifier = Modifier.background(color = Color(0XFF818181))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Controls",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "BMS", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }




}
@Preview
@Composable
fun ppp()
{
    Cards()
}