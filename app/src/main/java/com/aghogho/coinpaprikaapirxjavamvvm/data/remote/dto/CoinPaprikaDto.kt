package com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto

import com.aghogho.coinpaprikaapirxjavamvvm.domain.model.CoinPaprika
import com.google.gson.annotations.SerializedName

data class CoinPaprikaDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinPaprikaDto.toCoin(): CoinPaprika {
    return CoinPaprika(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}
