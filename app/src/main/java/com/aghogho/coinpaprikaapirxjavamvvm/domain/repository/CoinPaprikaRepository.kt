package com.aghogho.coinpaprikaapirxjavamvvm.domain.repository

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.CoinPaprikaDto
import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.coindetails.CoinDetailDto

interface CoinPaprikaRepository {

    fun getAllCoins(): List<CoinPaprikaDto>

    fun getCoinById(coinId: String): CoinDetailDto

}
