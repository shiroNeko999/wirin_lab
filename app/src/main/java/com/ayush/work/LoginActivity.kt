package com.ayush.work

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            }
        }
    }


@Composable
fun loginscreen(){
    Row(modifier= Modifier
        .fillMaxWidth()
        .background(Color.Black)) {
        Text(text = "Hello")
    }
}

@Composable
fun firebasebs(){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    loginscreen()
}