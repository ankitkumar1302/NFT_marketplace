package com.example.nftmarketplace.stats

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nftmarketplace.R
import com.example.nftmarketplace.rankings

@Composable
fun RankingRow(
    index: Int,
    title: String,
    image: Int,
    change: Double,
    eth: Double
) {
    Card(
        modifier = Modifier.clickable {},
//        elevation = CardDefaults.cardElevation(pressedElevation = 2.dp, focusedElevation = 5.dp, hoveredElevation = 1.dp),
        elevation = CardDefaults.cardElevation(
            pressedElevation = 2.dp,
            focusedElevation = 5.dp,
            hoveredElevation = 1.dp
        ),
        colors = CardDefaults.cardColors(Color.White.copy(0.15f)),

//        colors = CardDefaults.cardColors(Color(66,34,104))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                (index + 1).toString() + ".",
                fontSize = 15.sp,
                color = Color(235, 235, 245).copy(0.6f),
                modifier = Modifier.padding(end = 10.dp)
            )
            Image(
                painter = painterResource(id = image), contentDescription = "",
                modifier = Modifier
                    .padding(vertical = 11.dp)
                    .padding(end = 15.dp)
                    .height(44.dp)
                    .width(44.dp)
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
            )
            Column {
                Text(
                    title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    color = White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    "view info",
                    fontSize = 13.sp,
                    color = Color(235, 235, 245).copy(0.6f)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.eth_icon),
                        contentDescription = "ETH Logo",
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        eth.toString(),
                        color = White,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Left
                    )
                }
                Text(
                    "$change%",
                    color = if (change > 0) {
                        Color.Green
                    } else {
                        Color.Red
                    },
                    fontSize = 13.sp
                )

            }
        }
    }
}

@Preview
@Composable
fun RankingRowPreview() {
    RankingRow(
        index = 0,
        title = rankings[0].title,
        image = rankings[0].image,
        change = rankings[0].percentChange,
        eth = rankings[0].eth
    )
}