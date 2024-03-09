package com.ayush.work


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ProfileUp(justtext:String){
    Box(modifier= Modifier
        .fillMaxWidth()
        ){
        Image(modifier=Modifier.fillMaxWidth(),painter = painterResource(id = R.drawable.rectangle_49), contentDescription ="" )
        Text(text=justtext,
            color=Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 54.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.ExtraBold,
            modifier= Modifier
                .padding(top=74.dp, start = 34.dp)
        )
    }
}



@Composable
fun ProfileDown(Name:String,EmailID:String,Age:String){
    LazyRow(modifier=Modifier) {
        item {

            Card(modifier= Modifier
                .wrapContentWidth()
                .padding(10.dp)
                .background(
                    brush = GradientBackgroundBrush(
                        isVerticalGradient = true,
                        colors = listOf(


                            Color(0XFF1F1A5C),
                            Color(0xFF18162B),
                            Color(0XFF000000),
                        )
                    ), shape = RoundedCornerShape(20.dp)
                ),  backgroundColor = Color.Transparent
            ) {
            Column(modifier=Modifier.width(200.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth())
                Text(text = "Name", fontWeight = FontWeight.ExtraBold, fontSize = 25.sp, fontFamily = FontFamily.SansSerif, color = Color.White)
                Spacer(modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth())
                Text(text= Name, fontWeight= FontWeight.Normal, color= Color.White, fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
                Spacer(modifier = Modifier
                    .height(25.dp)
                    .fillMaxWidth())
            }
        } }
        item {

            Card(modifier= Modifier
                .wrapContentWidth()
                .padding(10.dp)
                .background(
                    brush = GradientBackgroundBrush(
                        isVerticalGradient = true,
                        colors = listOf(


                            Color(0XFF1F1A5C),
                            Color(0xFF18162B),
                            Color(0XFF000000),
                        )
                    ), shape = RoundedCornerShape(20.dp)
                ),  backgroundColor = Color.Transparent
            ) {
                Column(modifier=Modifier.width(200.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth())
                    Text(text = "Age", fontWeight = FontWeight.ExtraBold, fontSize = 25.sp, fontFamily = FontFamily.SansSerif, color = Color.White)
                    Spacer(modifier = Modifier
                        .height(30.dp)
                        .fillMaxWidth())
                    Text(text= Age, fontWeight= FontWeight.Normal, color= Color.White, fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
                    Spacer(modifier = Modifier
                        .height(25.dp)
                        .fillMaxWidth())
                }
            } }
        item {

            Card(modifier= Modifier

                .padding(10.dp)
                .background(
                    brush = GradientBackgroundBrush(
                        isVerticalGradient = true,
                        colors = listOf(


                            Color(0XFF1F1A5C),
                            Color(0xFF18162B),
                            Color(0XFF000000),
                        )
                    ), shape = RoundedCornerShape(20.dp)
                ),  backgroundColor = Color.Transparent
            ) {
                Column(modifier=Modifier.width(300.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth())
                    Text(text = "Email", fontWeight = FontWeight.ExtraBold, fontSize = 25.sp, fontFamily = FontFamily.SansSerif, color = Color.White)
                    Spacer(modifier = Modifier
                        .height(30.dp)
                        .fillMaxWidth())
                    Text(text= EmailID, fontWeight= FontWeight.Normal, color= Color.White, fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
                    Spacer(modifier = Modifier
                        .height(25.dp)
                        .fillMaxWidth())
                }
            } }

    }


}

@Composable
fun ProfileOptions(navController: NavHostController,name:String) {
    Box(modifier = Modifier.fillMaxSize()){

    Card(modifier= Modifier
        .padding(20.dp)

        .fillMaxSize()
        .background(
            brush = GradientBackgroundBrush(
                isVerticalGradient = false,
                colors = listOf(


                    Color(0xFF000000),
                    Color(0xFF000000),
                    Color(0XFF181818),
                )
            ), shape = RoundedCornerShape(20.dp)
        ), backgroundColor = Color.Transparent) {
        Column(modifier=Modifier.padding(start=50.dp, top=44.dp, end = 50.dp)) {
            var lol by remember {
                mutableStateOf(Color.Gray)
            }
            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxWidth())
            Text(text = "Edit Your Profile", color = lol, fontSize =24.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.SemiBold, modifier = Modifier.clickable {lol=Color.White
                navController.navigate("Edit Profile")})


            Spacer(modifier = Modifier
                .height(45.dp)
                .fillMaxWidth())
            Text(text = "Change your Password", color = lol, fontSize =24.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.SemiBold, modifier = Modifier.clickable {lol=Color.White
                navController.navigate("Change Password")
            })

            Spacer(modifier = Modifier
                .height(45.dp)
                .fillMaxWidth())
            Text(text = "Change your Password", color = lol, fontSize =24.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.SemiBold, modifier = Modifier.clickable {lol=Color.White
                navController.navigate("Home/$name")
            })


    }}
}}

@Composable
fun Profile(name: String?, age: String?, emailID: String?, navController: NavHostController){
    Column(modifier= Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        ProfileUp("Your\nProfile")
        Spacer(modifier = Modifier
            .height(20.dp)
            .fillMaxWidth())
        if (emailID != null) {
            if (name != null) {
                if (age != null) {
                    ProfileDown(name, emailID,age)
                }
            }
        }
        Spacer(modifier = Modifier
            .height(40.dp)
            .fillMaxWidth())
        if (name != null) {
            ProfileOptions(navController,name=name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileView(){

}