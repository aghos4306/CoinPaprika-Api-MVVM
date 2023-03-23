package com.aghogho.coinpaprikaapirxjavamvvm.domain.repository

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.CoinPaprikaDto
import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.coindetails.CoinDetailDto

interface CoinPaprikaRepository {

    suspend fun getAllCoins(): List<CoinPaprikaDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}
