package com.aghogho.coinpaprikaapirxjavamvvm.domain.usecase.get_single_coin

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.coindetails.toCoinDetail
import com.aghogho.coinpaprikaapirxjavamvvm.domain.model.CoinPaprikaDetail
import com.aghogho.coinpaprikaapirxjavamvvm.domain.repository.CoinPaprikaRepository
import com.aghogho.coinpaprikaapirxjavamvvm.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetSingleDetailCoinUseCase @Inject constructor(
    private val repository: CoinPaprikaRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinPaprikaDetail>> = flow {
        try {
            emit(Resource.Loading<CoinPaprikaDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinPaprikaDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinPaprikaDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinPaprikaDetail>("Couldn't reach server, check net connection"))
        }
    }

}
