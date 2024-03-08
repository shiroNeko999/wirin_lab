package com.ayush.work

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home()
{val scaffoldState= rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Log.d(ContentValues.TAG, "distance travelled  " + MyClass.distance)

    Scaffold(
        scaffoldState = scaffoldState,

        drawerContent = { DrawerPanel(scaffoldState = scaffoldState, scope =scope )},
        topBar = {
           TopBar(scaffoldState=scaffoldState,scope = scope)
        }
    ) {

        Column {
            HomeUp()
            TabBar()
        }
    }}

@Preview(showBackground = true)
@Composable
fun HomePrev(){
    Home()
}



