package com.ayush.work

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.database.database

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Controls_page() {
    var context = LocalContext.current
    // Write a message to the database
    var lightStatus by remember {
        mutableStateOf(0)
    }
    var headlightStatus by remember {
        mutableStateOf(0)

    }
    var ac_status by remember {
        mutableStateOf(0)

    }

    val database = Firebase.database
    val myReference = database.getReference("Realtime_DATA").child("CAR")
        .child("Lights").child("Internal Lights").child("Roof Light")

    val myReference2 = database.getReference("Realtime_DATA").child("CAR")
        .child("Lights").child("Headlight")
    val myReference3 = database.getReference("Realtime_DATA").child("CAR").child("HVAC")
        .child("AC Status")

    if (lightStatus == 1) {

        myReference.setValue("ON")
    } else {
        myReference.setValue("OFF")
    }
    if (headlightStatus == 1) {

        myReference2.setValue("ON")
    } else {
        myReference2.setValue("OFF")
    }
    if (ac_status == 1) {

        myReference3.setValue("ON")
    } else {
        myReference3.setValue("OFF")
    }




    Row {
        Card(
            onClick = { },
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(0.5f)
                .padding(10.dp),
            shape = RoundedCornerShape(10.dp), elevation = 10.dp
        ) {
            Column(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    IconButton(onClick = { lightStatus = 1 }) {
                        Icon(
                            painter = painterResource(id = R.drawable.lighton),
                            contentDescription = "Control Unit Status",
                            modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                        )
                    }
                    IconButton(onClick = { lightStatus = 0 }) {
                        Icon(
                            painter = painterResource(id = R.drawable.lightoff),
                            contentDescription = "Control Unit Status",
                            modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                        )
                    }


                }
                Text(
                    color = Color.White,
                    text = "Roof Lights",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Monospace,

                    modifier = Modifier.padding(20.dp, 20.dp)
                )
            }
        }
        Row {
            Card(
                onClick = { },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp), elevation = 10.dp
            ) {
                Column(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                        IconButton(onClick = { headlightStatus = 1 }) {
                            Icon(
                                painter = painterResource(id = R.drawable.lighton),
                                contentDescription = "Control Unit Status",
                                modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                            )
                        }
                        IconButton(onClick = { headlightStatus = 0 }) {
                            Icon(
                                painter = painterResource(id = R.drawable.lightoff),
                                contentDescription = "Control Unit Status",
                                modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                            )
                        }


                    }
                    Text(
                        color = Color.White,
                        text = "Headlights",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,

                        modifier = Modifier.padding(20.dp, 20.dp)
                    )
                }
            }

        }

        }
        Row {
            Card(
                onClick = { },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(0.5f)
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp), elevation = 10.dp
            ) {
                Column(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                        IconButton(onClick = { ac_status = 1 }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ac_on),
                                contentDescription = "Control Unit Status",
                                modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                            )
                        }
                        IconButton(onClick = { ac_status = 0 }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ac_off),
                                contentDescription = "Control Unit Status",
                                modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                            )
                        }


                    }
                    Text(
                        color = Color.White,
                        text = "AC Control",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,

                        modifier = Modifier.padding(20.dp, 20.dp)
                    )
                }


            }
            Card(
                onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp), elevation = 10.dp
            ) {
                Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    Icon(
                        painter = painterResource(id = R.drawable.lighton),
                        contentDescription = "Control Unit Status",
                        modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                    )
                    Text(
                        color = Color.White,
                        text = "LIGHT",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,

                        modifier = Modifier.padding(20.dp, 20.dp)
                    )


                }


            }
        }
        Row {
            Card(
                onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(0.5f)
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp), elevation = 10.dp
            ) {
                Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    Icon(
                        painter = painterResource(id = R.drawable.lighton),
                        contentDescription = "Control Unit Status",
                        modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                    )
                    Text(
                        color = Color.White,
                        text = "LIGHT",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,

                        modifier = Modifier.padding(20.dp, 20.dp)
                    )


                }


            }
            Card(
                onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp), elevation = 10.dp
            ) {
                Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    Icon(
                        painter = painterResource(id = R.drawable.lighton),
                        contentDescription = "Control Unit Status",
                        modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                    )
                    Text(
                        color = Color.White,
                        text = "LIGHT",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,

                        modifier = Modifier.padding(20.dp, 20.dp)
                    )


                }


            }
        }
        Row {
            Card(
                onClick = { lightStatus = 1 },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(0.5f)
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp), elevation = 10.dp
            ) {
                Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    Icon(
                        painter = painterResource(id = R.drawable.lighton),
                        contentDescription = "Control Unit Status",
                        modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                    )
                    Text(
                        color = Color.White,
                        text = "LIGHT",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,

                        modifier = Modifier.padding(20.dp, 20.dp)
                    )


                }


            }
            Card(
                onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp), elevation = 10.dp
            ) {
                Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    Icon(
                        painter = painterResource(id = R.drawable.lighton),
                        contentDescription = "Control Unit Status",
                        modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                    )
                    Text(
                        color = Color.White,
                        text = "LIGHT",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,

                        modifier = Modifier.padding(20.dp, 20.dp)
                    )


                }


            }
        }
        Row {
            Card(
                onClick = { lightStatus = 1 },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(0.5f)
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp), elevation = 10.dp
            ) {
                Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    Icon(
                        painter = painterResource(id = R.drawable.lighton),
                        contentDescription = "Control Unit Status",
                        modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                    )
                    Text(
                        color = Color.White,
                        text = "LIGHT",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,

                        modifier = Modifier.padding(20.dp, 20.dp)
                    )


                }


            }
            Card(
                onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp), elevation = 10.dp
            ) {
                Row(modifier = Modifier.background(color = Color(0xFF1F0430))) {
                    Icon(
                        painter = painterResource(id = R.drawable.lighton),
                        contentDescription = "Control Unit Status",
                        modifier = Modifier.padding(20.dp, 20.dp), tint = Color.White
                    )
                    Text(
                        color = Color.White,
                        text = "LIGHT",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace,

                        modifier = Modifier.padding(20.dp, 20.dp)
                    )


                }


            }
        }
    }



