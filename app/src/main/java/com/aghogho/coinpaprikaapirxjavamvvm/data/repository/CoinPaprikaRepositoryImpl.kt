package com.aghogho.coinpaprikaapirxjavamvvm.data.repository

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.CoinPaprikaApi
import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.CoinPaprikaDto
import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.coindetails.CoinDetailDto
import com.aghogho.coinpaprikaapirxjavamvvm.domain.repository.CoinPaprikaRepository
import javax.inject.Inject

class CoinPaprikaRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
): CoinPaprikaRepository{
    override fun getAllCoins(): List<CoinPaprikaDto> {
        return coinPaprikaApi.getAllCoins()
    }

    override fun getCoinById(coinId: String): CoinDetailDto {
        return coinPaprikaApi.getCoinById(coinId)
    }

}
