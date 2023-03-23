package com.aghogho.coinpaprikaapirxjavamvvm.presentation.coin_detail_screen

import com.aghogho.coinpaprikaapirxjavamvvm.domain.model.CoinPaprikaDetail

data class CoinPaprikaDetailState(
    val isLoading: Boolean = false,
    val coin: CoinPaprikaDetail? = null,
    val error: String = ""
)
