package com.example.nftmarketplace.stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nftmarketplace.Ranking
import com.example.nftmarketplace.rankings
import com.example.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun RankingTable(rankings: List<Ranking>) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(rankings) { index, ranking ->
            RankingRow(
                index = index,
                title = ranking.title,
                image = ranking.image,
                change = ranking.percentChange,
                eth = ranking.eth
            )
        }
    }
}

@Preview
@Composable
fun RankingTablePreview() {
    NFTMarketplaceTheme {
        RankingTable(rankings = rankings)
    }
}