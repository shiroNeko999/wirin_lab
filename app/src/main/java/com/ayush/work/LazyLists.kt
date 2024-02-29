package com.ayush.work

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

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