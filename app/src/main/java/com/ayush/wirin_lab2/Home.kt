package com.ayush.wirin_lab2

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.ayush.wirin_lab2.ui.theme.Mytheme

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



