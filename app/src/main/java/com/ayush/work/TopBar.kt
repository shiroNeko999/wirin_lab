package com.ayush.work

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(scaffoldState: ScaffoldState,scope: CoroutineScope)
{
    Row(modifier = Modifier.background(color = Color.White)
        .fillMaxWidth()) {
        IconButton(onClick = {scope?.launch { scaffoldState?.drawerState?.open() }}) {
            Image(painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                contentDescription = "Hamburger menu icon",
                modifier = Modifier.padding(horizontal = 5.dp))

        }
        Text(
            fontWeight = FontWeight.ExtraBold,
            text = "WIPOD 2.0-WIRIN",
            color = Color(0XFF212121),
            fontFamily = FontFamily.Monospace,
            fontSize = 30.sp
        )

    }
}
