package com.example.nftmarketplace.stats

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nftmarketplace.rankings

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StatsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = 10.dp),
                title = {
                    Column {
                        Text(
                            "Stats",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent)
//                backgroundColor = Color.Transparent,
//                elevation = 0.dp
            )
        },
        containerColor = Color(33, 17, 52)
//        backgroundColor = Color(33, 17, 52)
    ) {
        Column(
            Modifier.padding(bottom = 20.dp)
        ) {
            Spacer(modifier = Modifier.padding(35.dp))
            CustomTabComponent()
            Card(
                colors = CardDefaults.cardColors(Color.White.copy(0.15f)),
//                backgroundColor= Color.White.copy(0.15f),
//                elevation = 0.dp,
                border = BorderStroke(1.5.dp, Color.White.copy(0.5f)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(16.dp, 20.dp),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                RankingTable(rankings)
            }
        }
    }
}

@Composable
fun CustomTabComponent() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        "Ranking" to Icons.Default.Assessment,
        "Activity" to Icons.Default.TrackChanges
    )
    TabRow(
        selectedTabIndex = tabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider(
                thickness = 1.dp,
                color = Color(66, 34, 104)
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabOffset(tabPositions[tabIndex]),
                height = 4.dp,
                color = Color(148, 103, 255)
            )
        }
    ) {
        tabData.forEachIndexed { index, pair ->
            Tab(modifier = Modifier.padding(5.dp),
                selected = tabIndex == index,
                selectedContentColor = Color(66, 34, 104),
                onClick = {
                    tabIndex = index

                },
                content = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = pair.second,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Text(
                            pair.first,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 17.sp,
                            color = Color.White
                        )
                    }
                }
            )
        }
    }
}


fun Modifier.customTabOffset(tabPosition: TabPosition): Modifier = composed {
    val indicatorWidth = 118.dp
    val currentTabWidth = tabPosition.width
    val indicatorOffset by animateDpAsState(
        targetValue = tabPosition.left + currentTabWidth / 2 - indicatorWidth / 2,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(indicatorWidth)
}

@Preview
@Composable
fun StatsScreenPreview() {
    StatsScreen()
}


//@Composable
//fun CustomTabComponent() {
//    var tabIndex by remember { mutableStateOf(0) }
//    val tabData = listOf(
//        "Ranking" to Icons.Default.Assessment,
//        "Activity" to Icons.Default.TrackChanges
//    )
//    TabRow(selectedTabIndex = tabIndex,
//        backgroundColor = Color.Transparent,
//        contentColor = Color.White,
//        divider = {
//            TabRowDefaults.Divider(
//                thickness = 1.dp,
//                color = Color(66, 34, 104)
//            )
//        },
//        indicator = { tabPositions ->
//            TabRowDefaults.Indicator(
//                modifier = Modifier.customTabOffset(tabPositions[tabIndex]),
//                height = 4.dp,
//                color = Color(148, 103, 255)
//            )
//        }
//    ) {
//        tabData.forEachIndexed { index, pair ->
//            Tab(
//                selected = tabIndex == index,
//                onClick = {
//                    tabIndex = index
//                },
//                content = {
//                    Row(
//                        modifier = Modifier.padding(bottom = 16.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        verticalAlignment = Alignment.CenterVertically
//
//                    ) {
//                        Icon(
//                            imageVector = pair.second, contentDescription = null,
//                            tint = Color.White
//                        )
//                        Text(
//
//                            pair.first,
//                            fontWeight = FontWeight.SemiBold,
//                            fontSize = 17.sp,
//                            color = Color.White
//                        )
//                    }
//                }
//            )
//        }
//    }
//}
//fun Modifier.customTabOffset(tabPosition: TabPosition): Modifier =
//    composed {
//        val indicatorWidth = 118.dp
//        val currentTabWidth = tabPosition.width
//        val indicatorOffset by animateDpAsState(
//            targetValue = tabPosition.left + currentTabWidth / 2 - indicatorWidth / 2,
//            animationSpec = tween(durationMillis = 1000, easing = FastOutLinearInEasing)
//        )
//        fillMaxWidth()
//            .wrapContentSize(Alignment.BottomStart)
//            .offset(x = indicatorOffset)
//            .width(indicatorWidth)
//    }