package com.ayush.wirin_lab2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeUp()
            TabBar()
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

