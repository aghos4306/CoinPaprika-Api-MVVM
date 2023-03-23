package com.aghogho.coinpaprikaapirxjavamvvm.presentation.coin_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aghogho.coinpaprikaapirxjavamvvm.domain.model.CoinPaprikaDetail
import com.aghogho.coinpaprikaapirxjavamvvm.domain.usecase.get_single_coin.GetSingleDetailCoinUseCase
import com.aghogho.coinpaprikaapirxjavamvvm.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinPaprikaDetailViewModel @Inject constructor(
    private val getSingleDetailCoinUseCase: GetSingleDetailCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinPaprikaDetailState())
    val state: State<CoinPaprikaDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getSingleCoin(coinId)
        }
    }

    private fun getSingleCoin(coinId: String) {
        getSingleDetailCoinUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinPaprikaDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinPaprikaDetailState(
                        error = result.message ?: "Unable to load data"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinPaprikaDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    companion object {
        const val PARAM_COIN_ID = "coinId"
    }

}
