package com.ayush.work

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope

@Composable
fun Home()
{val scaffoldState= rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,

        drawerContent = { DrawerPanel(scaffoldState = scaffoldState, scope =scope )},
        topBar = {
           TopBar(scaffoldState=scaffoldState,scope = scope)
        }
    ) {

        Column() {
            HomeUp()
            TabBar()
        }
    }}



