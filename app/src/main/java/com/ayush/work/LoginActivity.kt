package com.ayush.work

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


sealed class AuthResult {
    data class Success(val user: FirebaseUser) : AuthResult()
    data class Failure(val exception: Exception) : AuthResult()
    object EmptyFields : AuthResult()
}


class LoginActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)







        setContent {

        }
    }
}


@Composable
fun loginscreen(navController: NavHostController) {
    Column(modifier= Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        LazyColumn{
            item { DesignTop()
                DesignBottom(navController) }
        }

    }
}

@Composable
fun DesignTop(){
    Box(modifier= Modifier
        .navigationBarsPadding()
        .background(Color.Black), contentAlignment= Alignment.Center) {

        Image(
            painter = painterResource(id = R.drawable.subtract),
            contentDescription = null, // Provide a meaningful content description
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds // Adjust content scale as needed
        )
        Image(
            painter = painterResource(id = R.drawable.riyalwipod),
            contentDescription = null, // Provide a meaningful content description
            modifier= Modifier
                .wrapContentSize()
                .align(Alignment.TopCenter)
                .scale(0.65f)
                .padding(top = 70.dp),
            contentScale = ContentScale.FillBounds // Adjust content scale as needed
        )
        Text(text="Login",
            color=Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 38.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.ExtraBold,
            modifier= Modifier
                .padding(0.dp)
                .align(Alignment.BottomCenter),
        )

    }
}

@Composable
fun DesignBottom(navController: NavHostController){
    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current

    var authResult by remember { mutableStateOf<AuthResult?>(null) }

    var passwordVisible by remember { mutableStateOf(false) }
    var name="GuestUser"
    Column(modifier= Modifier
        .background(Color.Black)
        .fillMaxSize()
        .padding(top = 32.dp)) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("")}

        val onGoogleSignInClick: () -> Unit = {
            //Sign in vala function yaha daalna
            var hey=0
            hey+=1

        }
        val onMetaSignInClick: () -> Unit = {
            //Sign in vala function yaha daalna
            var hey=0
            hey+=1
        }

            //login hone pr ka logic
        val onLoginClick: () -> Unit = {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Authentication success
                            val user = task.result?.user
                            if (user != null) {
                                authResult = AuthResult.Success(user)
                                Toast.makeText(context, "Logged in", Toast.LENGTH_SHORT).show()
                                navController.navigate("Home/$name")
                            } else {
                                // Handle the case where the user is null
                                Toast.makeText(context, "Enter your email adress", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            // Authentication failed
                            authResult = AuthResult.Failure(task.exception!!)
                            Toast.makeText(context, "Incorrect Credentials", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                // Handle empty email or password fields
                authResult = AuthResult.EmptyFields
                Toast.makeText(context, "Make sure to fill all details", Toast.LENGTH_SHORT).show()
            }
        }




        val onCreateAccountClick: ()-> Unit = {

            navController.navigate("Register Screen")

        }
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },shape = RoundedCornerShape(10.dp),
            trailingIcon = {
                Icon(Icons.Filled.Face, "", tint = Color.Gray)},
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
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
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 35.dp)
                .fillMaxWidth(),
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
            }
            ,colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor= Color.Black,
                errorIndicatorColor = Color.Red,
                disabledTextColor = Color.Gray,
                focusedIndicatorColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Gray,

                ))

        Text(text="Forgot Password?", color=Color.White, modifier= Modifier
            .padding(end = 25.dp, top = 15.dp)
            .align(Alignment.End))

        Spacer(modifier = Modifier.padding(13.dp))

        LoginButton (onClick = onLoginClick)

        Spacer(modifier = Modifier.padding(8.dp))

        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.Absolute.SpaceBetween) {
            GoogleSignInButton(onClick = onGoogleSignInClick, modifier = Modifier.weight(0.75f))
            MetaSignInButton(onClick = onMetaSignInClick, modifier= Modifier.weight(1f))
        }




        Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            CreateAccountText(onCreateAccountClick= onCreateAccountClick)
        }






    }
}

@Composable
fun CreateAccountText(onCreateAccountClick: () -> Unit) {
    var textColor by remember { mutableStateOf(Color.Gray) }

    ClickableText(
        text = AnnotatedString("Don't have an account? Create one now"),
        onClick = {
            textColor = Color.White // Change text color on click
            onCreateAccountClick()
        },
        style = MaterialTheme.typography.body1.copy(color = textColor),
        modifier = Modifier.padding(8.dp)
    )
}


@Composable
fun GoogleSignInButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        elevation = ButtonDefaults.elevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(10.dp),
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
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF334155),
            contentColor = Color.White
        ), shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.button
        )
    }
}
@Composable
fun MetaSignInButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        elevation = ButtonDefaults.elevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(10.dp),
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
fun GreetingPreview() {


}
//@Preview(showBackground = true)
//@Composable
//fun lol(){
//    DesignTop()

