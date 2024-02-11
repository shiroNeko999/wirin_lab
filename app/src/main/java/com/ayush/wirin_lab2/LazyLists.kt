package com.ayush.wirin_lab2

import android.content.ClipData.Item
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LazyListt()
{
    LazyColumn {
        // Add a single item
       item{
           Cards()
       }
    }

}
@Composable
fun LazyList2()
{
    LazyColumn{
        item { Controls_page() }
    }
}
@Preview
@Composable
fun La(){
    LazyList2()
}