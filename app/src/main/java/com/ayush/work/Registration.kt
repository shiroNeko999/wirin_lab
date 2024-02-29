package com.ayush.work

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun Registration()

{   val context = LocalContext.current
    var Username by remember { mutableStateOf("")}
    var passwordVisible by remember { mutableStateOf(false) }
    var Password by remember { mutableStateOf("")}

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
        TextField(value = Username, onValueChange = {Username= it}, shape = RoundedCornerShape(10.dp), trailingIcon = {
            Icon(Icons.Filled.Face, "", tint = Color.Gray)
        }, label = { Text(
            text = "Username"
        )})
        TextField(modifier = Modifier.padding(20.dp),shape = RoundedCornerShape(10.dp)
            ,value = Password,
            onValueChange = { Password = it },
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
        Button(modifier = Modifier
            .width(120.dp)
            .padding(10.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF495E57)),onClick = { Toast.makeText(context,"SignUp",Toast.LENGTH_SHORT).show() }) {
            Text(text = "SignUp",color = Color(0xFFEDEFEE))
        }
        Button(modifier = Modifier
            .width(120.dp)
            .padding(10.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF495E57)),onClick = { Toast.makeText(context,"Login",Toast.LENGTH_SHORT).show() }) {
            Text(text = "Login",color = Color(0xFFEDEFEE))
        }


    }
}