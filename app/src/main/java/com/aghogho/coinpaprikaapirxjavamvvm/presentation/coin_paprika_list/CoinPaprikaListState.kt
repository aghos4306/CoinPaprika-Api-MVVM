package com.aghogho.coinpaprikaapirxjavamvvm.presentation.coin_paprika_list

import com.aghogho.coinpaprikaapirxjavamvvm.domain.model.CoinPaprika

data class CoinPaprikaListState(
    val isLoading: Boolean = false,
    val coins: List<CoinPaprika> = emptyList(),
    val error: String = ""
)
