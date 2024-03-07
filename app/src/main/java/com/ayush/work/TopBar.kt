package com.ayush.work

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(scaffoldState: ScaffoldState,scope: CoroutineScope)
{
    Row(modifier = Modifier.background(color = Color.Black)
        .fillMaxWidth()) {
        IconButton(onClick = {scope?.launch { scaffoldState?.drawerState?.open() }}) {
            Image(painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                contentDescription = "Hamburger menu icon",
                modifier = Modifier.padding(horizontal = 5.dp).size(40.dp))

        }


        Icon( painter = painterResource(id = R.drawable.riyalwipod),
            contentDescription = "Wipod Logo on Top",
            modifier = Modifier.padding(0.dp).size(50.dp).weight(1f),
            tint = Color.White

        )

    }
}
