package com.ayush.work

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EditProfile(){
        Column(modifier= Modifier
            .background(Color.Black)
            .fillMaxSize()
            .padding(top = 22.dp), verticalArrangement = Arrangement.Top) {
            var textState by remember { mutableStateOf(TextFieldValue()) }
            var textState2 by remember { mutableStateOf(TextFieldValue()) }
            var textState3 by remember {mutableStateOf(TextFieldValue())}
            var textState4 by remember {mutableStateOf(TextFieldValue())}
            val onUpdateProfile: () -> Unit = {
                //Sign in vala function yaha daalna
                var hey=0
                hey+=1

            }

            TextField(
                value = textState3,
                onValueChange = { textState3 = it },
                label = { Text("Name") },
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 35.dp)
                    .fillMaxWidth(),
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
                value = textState4,
                onValueChange = { textState4 = it },
                label = { Text("Age") },
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 35.dp)
                    .fillMaxWidth(),
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
                value = textState,
                onValueChange = { textState = it },
                label = { Text("Email") },
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 35.dp)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor= Color.Black,
                    errorIndicatorColor = Color.Red,
                    disabledTextColor = Color.Gray,
                    focusedIndicatorColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Gray,
                ))



            Spacer(modifier = Modifier.padding(20.dp))

            UpdateProfile(onClick = onUpdateProfile)


        }
}

@Composable
fun UpdateProfile(onClick: () -> Unit) {
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
            text = "Update My Profile",
            style = MaterialTheme.typography.button
        )
    }
}

@Composable
fun finalEditProfile(){
    Column(modifier=Modifier.fillMaxSize().background(Color.Black)) {
        ProfileUp(justtext = "Edit\nProfile")
        EditProfile()
    }

}

@Preview(showBackground = true)
@Composable
fun EditPrvw(){
    finalEditProfile()
}

