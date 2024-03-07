package com.ayush.work

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.SliderColors
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MusicPlayerUI() {
    var playState by remember { mutableStateOf(false) }
    var sliderValue by remember { mutableStateOf(0f) }
    var context = LocalContext.current

    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = GradientBackgroundBrush(
                    isVerticalGradient = true,
                    colors = listOf(
                        Color(0xFF111111),
                        Color(0xFF000000),
                        Color(0xE220192E),
                    )
                )
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Album Image
                Image(
                    painter = painterResource(id = R.drawable.currents),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                        .padding(2.dp)
                )
                Text(
                    text = "Let it happen",
                    fontWeight = FontWeight.W800,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White,
                    fontSize = 25.sp
                )
                Text(
                    text = "Tame Impala",
                    fontWeight = FontWeight.W100,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Slider(
                    value = sliderValue,
                    onValueChange = { newValue -> sliderValue = newValue },
                    valueRange = 0f..100f,
                    steps = 100,
                    modifier = Modifier.padding(4.dp),
                    colors = SliderDefaults.colors(
                        thumbColor = Color.White, // Set the color of the thumb
                        activeTrackColor = Color.White, // Set the color of the slider bar
                        inactiveTrackColor = Color.Gray // Set the color of the inactive part of the slider bar
                    )

                )

                Row(modifier = Modifier.padding(top = 4.dp, start = 70.dp), horizontalArrangement = Arrangement.Center) {
                    // Previous Button with Icon
                    IconButton(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Previous Song",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_skip_previous_24),
                            contentDescription = "Previous",
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    // Play/Pause Button with Icon
                    IconButton(
                        onClick = {
                            playState = !playState
                            if (playState) {
                                // Start increasing the slider value
                                sliderValue = 0f
                                GlobalScope.launch {
                                    while (playState && sliderValue < 100f) {
                                        delay(1000)
                                        sliderValue += 1f
                                    }
                                }
                            } else {
                                // Stop increasing the slider value

                            }
                            Toast.makeText(
                                context,
                                if (playState) "Playing" else "Paused",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Image(
                            painter = painterResource(if (playState) R.drawable.baseline_pause_24 else R.drawable.baseline_play_arrow_24),
                            contentDescription = if (playState) "Pause" else "Play",
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    // Next Button with Icon
                    IconButton(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Next Song",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_skip_next_24),
                            contentDescription = "Next",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }

                // Duration Slider

            }
        }
    }
}

@Preview
@Composable
fun PreviewMusicPlayerUI() {
    MusicPlayerUI()
}
