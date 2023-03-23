package com.aghogho.coinpaprikaapirxjavamvvm.data.repository

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.CoinPaprikaDto
import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.coindetails.CoinDetailDto
import com.aghogho.coinpaprikaapirxjavamvvm.domain.model.CoinPaprika
import com.aghogho.coinpaprikaapirxjavamvvm.domain.repository.CoinPaprikaRepository

class CoinPaprikaRepositoryFake: CoinPaprikaRepository {
    override suspend fun getAllCoins(): List<CoinPaprikaDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        TODO("Not yet implemented")
    }
}
