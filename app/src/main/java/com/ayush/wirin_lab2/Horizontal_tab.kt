package com.ayush.wirin_lab2



import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabBar() {

       val pagerState = rememberPagerState()
       val pages = listOf("Controls", "Map", "Security", "Car Stats")

// Map page titles to their corresponding icon resource IDs
       val pageIcons = mapOf(
           "Controls" to R.drawable.ic_baseline_directions_car_24,
           "Map" to R.drawable.ic_baseline_location_on_24,
           "Security" to R.drawable.ic_baseline_lock_24,
           "Car Stats" to R.drawable.ic_baseline_electric_bolt_24

       )

       val indicator = @Composable { tabPositions: List<TabPosition> ->
           CustomIndicator(tabPositions, pagerState)
       }

       ScrollableTabRow(
           modifier = Modifier.height(50.dp),
           backgroundColor = Color(0XFFfafafa),
           selectedTabIndex = pagerState.currentPage,
           indicator = indicator
       ) {
           pages.forEachIndexed { index, title ->
               Tab(
                   modifier = Modifier.zIndex(6f),
                   text = { Text(text = title, color = Color.Black,fontFamily = FontFamily.Monospace) },
                   icon = {
                       Icon(
                           painter = painterResource(
                               id = pageIcons[title] ?: R.drawable.ic_baseline_visibility_24
                           ),
                           contentDescription = title
                       )
                   },
                   selected = pagerState.currentPage == index,
                   onClick = { /* TODO */ },
               )
           }
       }

       HorizontalPager(
           modifier = Modifier.fillMaxSize(),
           count = pages.size,
           state = pagerState,
       ) { page ->
           if(page==3){
           Box(
               Modifier
                   .fillMaxWidth()
                   .background(color = Color(0XFF212121))) {
               Text(modifier = Modifier.align(Alignment.Center), text = "Page $page")
               LazyListt()
           }
           }
           if(page==0){
               Box(
                   Modifier
                       .fillMaxWidth()
                       .background(color = Color(0XFF212121))) {

                   LazyList2()
               }
           }
           else if (page==1 || page == 2){
               Box(
                   Modifier
                       .fillMaxSize()
                       .background(color = Color(0XFF212121))) {

                   Text(text = "COMING SOON.....", fontWeight = FontWeight.ExtraBold, fontSize = 50.sp, color = Color.White,
                       fontFamily = FontFamily.Monospace)
               }
           }
       }
   }


@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage)
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)

            .padding(2.dp)
            .fillMaxSize()
            .background(color = Color(0xFFf2f2f2), RoundedCornerShape(50))
            .border(BorderStroke(2.dp, Color(0xFFFFFFFF)), RoundedCornerShape(50))
            .zIndex(1f)
    )
}
@Preview
@Composable
fun pp()
{
    TabBar()
}