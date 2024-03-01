package com.ayush.work

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun HomeUp() {
    val gradientColors  = listOf(


        Color(0xFF000000),     // 100% - Color(0xFF000000)
        Color(0xFF05040E),     // 87%  - Color(0xFF05040E)
        Color(0xFF1F1A5C)      // 99%  - Color(0xFF1F1A5C)
    )
    var distance by remember { mutableStateOf("") }

    // Firebase listener to update distance
    val myRef = Firebase.database.getReference("Realtime_DATA/CAR/CAR_Data4/Distance Traveled")
    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val value = snapshot.getValue<String>()
            distance = value ?: ""
        }

        override fun onCancelled(error: DatabaseError) {
            // Handle error
        }
    })
    var parking by remember {
        mutableStateOf((""))
    }
    val myRef2 = Firebase.database.getReference("Realtime_DATA/CAR/CAR_Data4/DRIVE MODE")
    myRef2.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val value = snapshot.getValue<String>()
            parking = value ?: ""
        }

        override fun onCancelled(error: DatabaseError) {
            // Handle error
        }
    })

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.Blue

            )
            )



        Column(modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = GradientBackgroundBrush(
                    isVerticalGradient = false,
                    colors = gradientColors
                )
            )) {
            Row(modifier = Modifier.padding(6.dp)) {
               Icon(painter = painterResource(id = R.drawable.car), contentDescription ="Car",modifier = Modifier
                   .padding(0.dp)
                   .size(24.dp),  tint = Color.Unspecified
               )
                Text(text = "$distance km", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold,color = Color.White, modifier = Modifier.padding(10.dp,0.dp))

            }
            Text(text = parking, color = Color.White, modifier = Modifier.padding(10.dp,2.dp), fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.wipod_car), contentDescription ="Car image",
                modifier = Modifier
                    .padding(60.dp,10.dp,10.dp,10.dp)
                    .fillMaxWidth()
            )

        }
    }

@Preview
@Composable
fun mvp()
{
    HomeUp()
}


