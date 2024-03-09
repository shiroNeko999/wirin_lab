package com.ayush.work

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ayush.work.ui.theme.ProfileBox
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn( ExperimentalMaterialApi::class)
@Composable
fun DrawerPanel(
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    name: String,
    navController: NavController
)
{ var context = LocalContext.current
    var wow=0
    var age="none"
    var email="none"
    LazyColumn(modifier=Modifier.fillMaxSize().background(
        brush = GradientBackgroundBrush(
            isVerticalGradient = true,
            colors = listOf(


                Color(0xFF111111),
                Color(0xFF000000),
                Color(0xE220192E),
            )
        ))){
        item{ ProfileBox(userName = name, modifier=Modifier.padding(16.dp))}
        item { Row(modifier = Modifier.fillMaxWidth()
            .background(color = Color.Transparent)
            .clickable(onClick = { wow++ })
            .padding(16.dp)) {
                Spacer(modifier = Modifier.padding(10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.baseline_edit_note_24),
                    contentDescription = "Controls",
                    modifier = Modifier.padding(5.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    color = Color.White, text = "Your Profile", fontSize = 20.sp,fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.padding(20.dp, 5.dp).clickable(onClick = {navController.navigate("Your Profile/$name/$age/$email")})
                )
            }

         }

        item {   Row(modifier = Modifier
            .background(color = Color.Transparent).fillMaxWidth()
            .clickable(onClick = { wow++ })
            .padding(16.dp)) {
            Spacer(modifier = Modifier.padding(10.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_app_settings_alt_24),
                contentDescription = "Controls",
                modifier = Modifier.padding(5.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                color = Color.White, text = "Log Out", fontSize = 20.sp,fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(20.dp, 5.dp).clickable(onClick = {navController.navigate("Login")})
            )
        } }
      }
    IconButton(onClick = { scope?.launch { scaffoldState?.drawerState?.close() } }) {
        Icon(imageVector = Icons.Default.ExitToApp, contentDescription ="Close Icon" )

    }


}

