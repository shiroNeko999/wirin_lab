package com.ayush.work

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ChangePassword(){
    Column(modifier= Modifier
        .background(Color.Black)
        .fillMaxSize()
        .padding(top = 32.dp)) {
        var textState by remember { mutableStateOf(TextFieldValue()) }
        var textState2 by remember { mutableStateOf(TextFieldValue()) }


        val onChangePasswordButton: () -> Unit = {
            //Sign in vala function yaha daalna
            var hey=0
            hey+=1
        }



        TextField(
            value = textState,
            onValueChange = { textState2 = it },
            label = { Text("Old Password") },
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 35.dp, bottom = 8.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor= Color.Black,
                errorIndicatorColor = Color.Red,
                disabledTextColor = Color.Gray,
                focusedIndicatorColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Gray,
            ))

        TextField(
            value = textState2,
            onValueChange = { textState2 = it },
            label = { Text("New Password") },
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 35.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor= Color.Black,
                errorIndicatorColor = Color.Red,
                disabledTextColor = Color.Gray,
                focusedIndicatorColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Gray,
            ))

        Spacer(modifier = Modifier.padding(30.dp))

        ChangePasswordButton (onClick = onChangePasswordButton)
    }
}


@Composable
fun ChangePasswordButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF334155),
            contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Change My Password",
            style = MaterialTheme.typography.button
        )
    }
}

@Composable
fun finalChangePassword(){
    Column(modifier= Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        ProfileUp(justtext = "Change\nPassword")
        ChangePassword()
    }

}

@Preview(showBackground = true)
@Composable
fun PasswordPrvw(){
    finalChangePassword()
}
