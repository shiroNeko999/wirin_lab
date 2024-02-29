package com.ayush.work

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn( ExperimentalMaterialApi::class)
@Composable
fun DrawerPanel(scaffoldState: ScaffoldState,scope: CoroutineScope)
{ var context = LocalContext.current
    LazyColumn{
        item {   Card(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
            modifier = Modifier
                .height(85.dp)
                .fillMaxWidth()

                .padding(5.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(modifier = Modifier.background(color = Color(0XFF818181))) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                    contentDescription = "Controls",
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    color = Color.White, text = "OBC", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                    modifier = Modifier.padding(20.dp, 5.dp)
                )

            }

        } }

        item {   Card(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
            modifier = Modifier
                .height(85.dp)
                .fillMaxWidth()

                .padding(5.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(modifier = Modifier.background(color = Color(0XFF818181))) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                    contentDescription = "Controls",
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    color = Color.White, text = "OBC", fontSize = 20.sp,fontFamily = FontFamily.Monospace,

                    modifier = Modifier.padding(20.dp, 5.dp)
                )

            }

        } }
      }
    IconButton(onClick = { scope?.launch { scaffoldState?.drawerState?.close() } }) {
        Icon(imageVector = Icons.Default.ExitToApp, contentDescription ="Close Icon" )

    }


}