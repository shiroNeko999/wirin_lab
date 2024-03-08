package com.ayush.work



import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabBar() {
    val gradientColors  = listOf(


        Color(0xFF000000),     // 100% - Color(0xFF000000)
        Color(0xFF05040E),     // 87%  - Color(0xFF05040E)
        Color(0xFF1F1A5C)      // 99%  - Color(0xFF1F1A5C)
    )




       val pagerState = rememberPagerState()
       val pages = listOf("Controls", "Map", "Music", "Car Stats")

// Map page titles to their corresponding icon resource IDs
       val pageIcons = mapOf(
           "Controls" to R.drawable.ic_baseline_directions_car_24,
           "Map" to R.drawable.ic_baseline_location_on_24,
           "Music" to R.drawable.music,
           "Car Stats" to R.drawable.ic_baseline_electric_bolt_24

       )

       val indicator = @Composable { tabPositions: List<TabPosition> ->
           CustomIndicator(tabPositions, pagerState)
       }

       ScrollableTabRow(
           modifier = Modifier.height(50.dp).background( brush = GradientBackgroundBrush(
               isVerticalGradient = false,
               colors = gradientColors)),
backgroundColor =         Color(0xFF05040E)
           ,

           selectedTabIndex = pagerState.currentPage,
           indicator = indicator
       ) {
           pages.forEachIndexed { index, title ->
               Tab(
                   modifier = Modifier.zIndex(6f),
                   text = { Text(text = title, color = Color.White,fontFamily = FontFamily.Monospace) },
                   icon = {
                       Icon(
                           painter = painterResource(
                               id = pageIcons[title] ?: R.drawable.ic_baseline_visibility_24,


                           ),
                           tint = Color.White,
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
                   .background( brush = GradientBackgroundBrush(
                   isVerticalGradient = true,
                   colors = gradientColors))) {
               Text(modifier = Modifier.align(Alignment.Center), text = "Page $page")
               LazyListt()
           }
           }
           if(page==0){
               Box(
                   Modifier
                       .fillMaxWidth()
                       .background( brush = GradientBackgroundBrush(
                           isVerticalGradient = false,
                           colors = gradientColors))) {

                   LazyList2()
               }
           }
           if (page == 2){
               Box(
                   Modifier
                       .fillMaxSize()
                       .background( brush = GradientBackgroundBrush(
                           isVerticalGradient = false,
                           colors = gradientColors))) {

                   MusicPlayerUI()
               }
           }

           if (page==1){
               Box(
                   Modifier
                       .fillMaxSize()
                       .background( brush = GradientBackgroundBrush(
                           isVerticalGradient = false,
                           colors = gradientColors))) {

                   GoogleMapsScreen()
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

            .padding(0.dp)
            .fillMaxSize()
            .background(color = Color(0xFF030303), RoundedCornerShape(50))
            .border(BorderStroke(2.dp, Color(0xFFFCFCFC)), RoundedCornerShape(50))
            .zIndex(1f)
    )
}

@Preview
@Composable
fun pp()
{
    TabBar()
}