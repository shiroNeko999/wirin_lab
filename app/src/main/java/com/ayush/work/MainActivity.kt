package com.ayush.work

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.math.sign


class MainActivity : ComponentActivity() {
    private var brakeLevel by mutableStateOf("")
    private var gearStatus by mutableStateOf("")
    private var battery by mutableStateOf("")
    private var steer by mutableStateOf("")
    private var ac_status by mutableStateOf("")
    private var control_mode by mutableStateOf("")
    private var door_status by mutableStateOf("")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Write a message to the database
        FirebaseApp.initializeApp(this)
        val database = Firebase.database
//        val myRef = database.getReference("Message")
//        val myRef2 = database.getReference("Message")
//
//        myRef.setValue("This is a test Run!")
//        myRef2.setValue("Test run from android")
        // Read from the database
        val myRef3 = database.getReference("Realtime_DATA").child("CAR")
            .child("CAR_Data1").child("Brake Level")
        val myRef4 = database.getReference("Realtime_DATA").child("CAR")
            .child("CAR_Data1").child("Gear Status")
        val myRef5 = database.getReference("Realtime_DATA")
            .child("BMS").child("SOC(State of Charge)")
        val myRef6 = database.getReference("Realtime_DATA").child("CAR")
            .child("CAR_Data1").child("Steering Angle")
        val myRef7 = database.getReference("Realtime_DATA")
            .child("HVAC").child("AC Status")
        val myRef8 = database.getReference("Realtime_DATA")
            .child("Control Settings").child("Low Level Control Mode")
        val myRef9 = database.getReference("Realtime_DATA")
            .child("Vehicle Status").child("VehicleDoors").child("Door Status")



        myRef3.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<Int>()
                brakeLevel = value.toString()
                //creating object
                MyClass.brake =  brakeLevel
                Log.d(ContentValues.TAG, "BrakeLevel: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }

        })
        myRef4.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                gearStatus = value.toString()
// object creation for singleton class
                MyClass.gear = gearStatus

                Log.d(ContentValues.TAG, "GearStatus: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }

        })
        myRef5.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                battery= value.toString()
                //creating object
                MyClass.charge= battery
                Log.d(ContentValues.TAG, "SOC: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }

        })

        myRef6.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<Int>()
                steer = value.toString()
                //creating object
               MyClass.steering = steer
                Log.d(ContentValues.TAG, "Steering: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }

        })

        myRef7.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                ac_status = value.toString()
                //creating object
                MyClass.ac = ac_status
                Log.d(ContentValues.TAG, "AC: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }

        })
        myRef8.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                control_mode= value.toString()
                //creating object
                MyClass.c_mode = control_mode
                Log.d(ContentValues.TAG, "Control mode  " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }

        })
        myRef9.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                door_status= value.toString()
                //creating object
                MyClass.door = door_status
                Log.d(ContentValues.TAG, "door  " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }

        })


        setContent {
            finalEditProfile()
        }
    }
}


@Composable
fun login_screen() {
    var context = LocalContext.current
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))

    }
    var passwordVisible by remember { mutableStateOf(false) }


    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
        TextField(modifier = Modifier.padding(10.dp),shape = RoundedCornerShape(10.dp),
            trailingIcon = {
                Icon(Icons.Filled.Face, "", tint = Gray)}
            ,value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") })
        TextField(modifier = Modifier.padding(20.dp),shape = RoundedCornerShape(10.dp)
            ,value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            singleLine = true,
            placeholder = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    R.drawable.ic_baseline_visibility_24
                else  R.drawable.ic_baseline_visibility_off_24

                // Localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                // Toggle button to hide or display password
                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(painter = painterResource(id = image), contentDescription ="password eyes" )

                }
            }
        )

        Row(modifier = Modifier.padding(10.dp)) {
            Button(modifier = Modifier.width(100.dp),onClick = {if(username.text == "WIRIN" && password.text =="RVCE")
            {
                Toast.makeText(context, "Welcome to WIPOD",Toast.LENGTH_SHORT).show()
            }

            else{
                Toast.makeText(context,"Invalid Credentials"+"Please try again", Toast.LENGTH_SHORT).show()
            }
            }

                , colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF495E57)), shape = RoundedCornerShape(10.dp)) {

                Text(text = "Login", color = Color(0xFFEDEFEE))



            }




        }
        Button(modifier = Modifier.width(100.dp),onClick = {
            Toast.makeText(context,"Register", Toast.LENGTH_SHORT).show()

        }

            , colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF495E57)), shape = RoundedCornerShape(10.dp)) {

            Text(text = "Register", color = Color(0xFFEDEFEE))



        }
        Text(modifier = Modifier
            .padding(0.dp, 10.dp)
            .clickable {
                Toast
                    .makeText(context, "Forgot password", Toast.LENGTH_SHORT)
                    .show()
            }, text = "Forgot Password?",color = Color.Gray)








    }

}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview()
{
    login_screen()
}

