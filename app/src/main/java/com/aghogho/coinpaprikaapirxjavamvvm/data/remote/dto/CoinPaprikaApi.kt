package com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.coindetails.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getAllCoins(): List<CoinPaprikaDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}
