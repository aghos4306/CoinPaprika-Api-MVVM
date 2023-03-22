package com.aghogho.coinpaprikaapirxjavamvvm.domain.model

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.coindetails.TeamMember

data class CoinPaprikaDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
