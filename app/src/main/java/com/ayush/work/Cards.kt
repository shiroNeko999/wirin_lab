package com.ayush.work

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ayush.work.R
import com.ayush.work.ui.theme.Mytheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Cards()
{
    var context = LocalContext.current
    val gradientColors = listOf(
        Color(0XFF200D40),
        Color(0X876037A2)

    )
    var openDialog by remember { mutableStateOf(0) }



    if (openDialog==1) {
        Dialog(onDismissRequest = { openDialog = 0}) {
            val parameter = " BRAKE LEVEL"
            val description = "The brake level can vary from 0 to 300 varying on the intensity of the brake applied"
            //object creation
            var value = MyClass.brake
            Dialog_box(parameter , description,value)
        }
    }
    if (openDialog==2) {
        Dialog(onDismissRequest = { openDialog = 0}) {
            val parameter = " GEAR STATUS"
            val description = "The gear status of a vehicle indicates the current position of the transmission system, determining whether the vehicle is in park, neutral, drive or  reverse"

            var value = MyClass.gear

            Dialog_box(parameter , description, value)
        }
    }
    if (openDialog==3) {
        Dialog(onDismissRequest = { openDialog = 0}) {
            val parameter = " SOC(State of Charge)"
            val description = "Battery SoC stands for \"Battery State of Charge.\" It is a measurement that indicates the amount of energy remaining in a battery as a percentage of its total capacity."

            var value = MyClass.charge

            Dialog_box(parameter , description,value)
        }

    }

    if (openDialog==4) {
        Dialog(onDismissRequest = { openDialog = 0}) {
            val parameter = " AC "
            val description = "Shows the staus of the AC as ON or OFF"
            var value = MyClass.ac
            Dialog_box(parameter , description,value)
        }

    }
    if (openDialog==5) {
        Dialog(onDismissRequest = { openDialog = 0}) {
            val parameter = "  CONTROL MODE "
            var value = MyClass.c_mode
            val description = "Can vary from Autonomous LEVEL 5 or Autonomous LEVEL 4 or Autonomous LEVEL 3 or Autonomous LEVEL 2 or Autonomous LEVEL 1or Manual Mode or Hardware Mode"
            Dialog_box(parameter , description,value)
        }

    }
    if (openDialog==6) {
        Dialog(onDismissRequest = { openDialog = 0}) {
            val parameter = " STEERING ANGLE "
            val description = "The angle ( in degrees) by which the steering has been rotated"
            var value = MyClass.steering
            Dialog_box(parameter , description,value)
        }

    }
    if (openDialog==7) {
        Dialog(onDismissRequest = { openDialog = 0}) {
            val parameter = "C A R  M O D E "
            val description = "Can vary from ENTERTAINMENT MODE or AMBIENT MODE or FOCUS MODE or NIGHT MODE or RIDE MODE"
            Dialog_box(parameter , description,"55")
        }

    }
    if (openDialog==8) {
        Dialog(onDismissRequest = { openDialog = 0}) {
            val parameter = "Door Status"
            val description = "Indicates the status of the main door of the car as Open or Closed or Closing or Opening or Error"
            val value = MyClass.door
            Dialog_box(parameter , description,value)
        }

    }





    Card(onClick = { openDialog =1 },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()
            .padding(5.dp)
            .background(color = Color(0xFF000000)),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF000000))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "B R A K E  L E V E L",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Brake Level", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { openDialog = 2},
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(
            color = Color.Black
        )) {
            Icon(
                painter = painterResource(id = R.drawable.gear),
                contentDescription = "Gear status ",
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp), tint = Color.White,
            )
            Text(
                color = Color.White, text = "Gear Status", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { openDialog = 3 },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF01030A))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Motor Brake",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "SOC", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { openDialog = 4 },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF000000))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "ac",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "AC Status", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { openDialog = 5 },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF000000))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Low Level Control Mode",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Low Level Control Mode", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { openDialog = 6 },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF000000))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Steering Angle",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Steering Angle", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card(onClick = { openDialog= 7 },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF000000))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "Car Mode",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Car Mode", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    Card({openDialog = 8 },
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()

            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.background(color = Color(0xFF000000))) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                contentDescription = "door status",
                modifier = Modifier.padding(5.dp)
            )
            Text(
                color = Color.White, text = "Door Status", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                modifier = Modifier.padding(20.dp, 5.dp)
            )

        }

    }
    @Composable
    fun DialogM3() {

    }





}
@Preview
@Composable
fun ppp()
{
    Cards()
}