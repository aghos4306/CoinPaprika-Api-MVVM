package com.aghogho.coinpaprikaapirxjavamvvm.domain.model

data class CoinPaprika(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
