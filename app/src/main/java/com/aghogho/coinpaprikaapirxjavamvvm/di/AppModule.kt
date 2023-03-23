package com.aghogho.coinpaprikaapirxjavamvvm.di

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.CoinPaprikaApi
import com.aghogho.coinpaprikaapirxjavamvvm.data.repository.CoinPaprikaRepositoryImpl
import com.aghogho.coinpaprikaapirxjavamvvm.domain.repository.CoinPaprikaRepository
import com.aghogho.coinpaprikaapirxjavamvvm.util.Constants.COIN_PAPRIKA_BASE_URL
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(COIN_PAPRIKA_BASE_URL)
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(coinPaprikaApi: CoinPaprikaApi): CoinPaprikaRepository {
        return CoinPaprikaRepositoryImpl(coinPaprikaApi)
    }

}
