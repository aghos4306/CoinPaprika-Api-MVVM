package com.aghogho.coinpaprikaapirxjavamvvm.domain.usecase.get_all_coins

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.toCoin
import com.aghogho.coinpaprikaapirxjavamvvm.domain.model.CoinPaprika
import com.aghogho.coinpaprikaapirxjavamvvm.domain.repository.CoinPaprikaRepository
import com.aghogho.coinpaprikaapirxjavamvvm.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(
    private val repository: CoinPaprikaRepository
){

    operator fun invoke(): Flow<Resource<List<CoinPaprika>>> = flow {
        try {
            emit(Resource.Loading())
            val paprikaCoins = repository.getAllCoins().map { it.toCoin() }
            emit(Resource.Success(paprikaCoins))
        } catch (httpExp: HttpException) {
            emit(Resource.Error(httpExp.localizedMessage))
        } catch (ioExp: IOException) {
            emit(Resource.Error("Please check your connection, couldn't connect to server"))
        }
    }

}
