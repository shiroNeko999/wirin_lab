package com.ayush.work

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            signupscreen()
                }
            }
        }

@Composable
fun signupscreen(){
    Column(modifier= Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        LazyColumn{
            item { DesignTop1()
            DesignBottom1()}

        }

    }
}


@Composable
fun DesignTop1(){
    Box(modifier= Modifier
        .navigationBarsPadding()
        .background(Color.Black)) {

        Image(
            painter = painterResource(id = R.drawable.rectangle_3),
            contentDescription = null, // Provide a meaningful content description
            modifier = Modifier.scale(1.5f),
            contentScale = ContentScale.Inside // Adjust content scale as needed
        )
        Image(
            painter = painterResource(id = R.drawable.riyalwipod),
            contentDescription = null, // Provide a meaningful content description
            modifier= Modifier
                .wrapContentSize()
                .align(Alignment.TopCenter)
                .scale(0.65f)
                .padding(top = 70.dp),
            contentScale = ContentScale.Inside // Adjust content scale as needed
        )

    }
}

@Composable
fun DesignBottom1(){
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier= Modifier
        .background(Color.Black)
        .fillMaxSize()
        .padding(top = 32.dp)) {
        var textState by remember { mutableStateOf("") }
        var textState2 by remember { mutableStateOf("") }

        val onGoogleSignupClick: () -> Unit = {
            //Sign in vala function yaha daalna
            var hey=0
            hey+=1

        }
        val onMetaSignupClick: () -> Unit = {
            //Sign in vala function yaha daalna
            var hey=0
            hey+=1
        }
        val onSignupClick: () -> Unit = {
            //login hone pr ka logic
            val email = textState
            val password = textState2

            // Call the sign-up function with email and password
            signUpWithEmailAndPassword(email, password)

        }

        val onSigninClick: ()-> Unit = {

            //create account pr click krne pr kya dikhega


        }

        Text(text="Create your Account",
            color=Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 38.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.ExtraBold,
            modifier= Modifier
                .padding(24.dp)
                .align(Alignment.Start)
        )

        TextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("Email") },
            trailingIcon = {
                Icon(Icons.Filled.Face, "", tint = Color.Gray)},
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
                .fillMaxWidth(), shape = RoundedCornerShape(10.dp),
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
            label = { Text("Password") },
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 35.dp)
                .fillMaxWidth(),shape = RoundedCornerShape(10.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor= Color.Black,
                errorIndicatorColor = Color.Red,
                disabledTextColor = Color.Gray,
                focusedIndicatorColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Gray,
            ))

        Spacer(modifier = Modifier.padding(13.dp))

        SignupButton (onClick = onSignupClick)

        Spacer(modifier = Modifier.padding(8.dp))

        Text(text="Or Sign Up with", color=Color.White, modifier= Modifier
            .padding(end = 25.dp, top = 15.dp)
            .align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.padding(8.dp))

        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.Absolute.SpaceBetween) {
            GoogleSignupButton(onClick = onGoogleSignupClick, modifier = Modifier.weight(0.75f))
            MetaSignupButton(onClick = onMetaSignupClick, modifier= Modifier.weight(1f))
        }




        Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            LoginAccountText(onSigninClick= onSigninClick)
        }






    }
}

@Composable
fun LoginAccountText(onSigninClick: () -> Unit) {
    var textColor by remember { mutableStateOf(Color.Gray) }

    ClickableText(
        text = AnnotatedString("Already have an account? Login now"),
        onClick = {
            textColor = Color.White // Change text color on click
            onSigninClick()
        },
        style = MaterialTheme.typography.body1.copy(color = textColor),
        modifier = Modifier.padding(8.dp)
    )
}


@Composable
fun GoogleSignupButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        elevation = ButtonDefaults.elevation(defaultElevation = 10.dp),
        modifier = Modifier
            .width(185.dp)
            .height(56.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.googleicon),
                contentDescription = "Google Logo",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Google",
                style = MaterialTheme.typography.button,
                color = Color.Black
            )
        }
    }
}

@Composable
fun SignupButton(onClick: () -> Unit) {
    Button(
        onClick = onClick, shape = RoundedCornerShape(10.dp),
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
            text = "Create My Account",
            style = MaterialTheme.typography.button
        )
    }
}
@Composable
fun MetaSignupButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        elevation = ButtonDefaults.elevation(defaultElevation = 10.dp),
        modifier = Modifier
            .width(185.dp)
            .height(56.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.metariyal),
                contentDescription = "Meta",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Meta",
                style = MaterialTheme.typography.button,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    signupscreen()
}
private fun signUpWithEmailAndPassword(email: String, password: String) {
    val auth = FirebaseAuth.getInstance()
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign-up success
                val user = auth.currentUser
                // You can handle the signed-up user here
            } else {
                // Sign-up failed
                val exception = task.exception
                // You can handle the sign-up failure here
            }
        }
}