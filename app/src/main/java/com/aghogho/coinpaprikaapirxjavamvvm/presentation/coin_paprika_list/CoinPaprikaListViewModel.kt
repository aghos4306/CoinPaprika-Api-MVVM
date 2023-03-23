package com.aghogho.coinpaprikaapirxjavamvvm.presentation.coin_paprika_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aghogho.coinpaprikaapirxjavamvvm.domain.usecase.get_all_coins.GetAllCoinsUseCase
import com.aghogho.coinpaprikaapirxjavamvvm.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinPaprikaListViewModel @Inject constructor(
    private val getAllCoinsUseCase: GetAllCoinsUseCase
): ViewModel() {

    private val _state = mutableStateOf(CoinPaprikaListState())
    val state: State<CoinPaprikaListState> = _state

    init {
        getAllCoins()
    }

    private fun getAllCoins() {
        getAllCoinsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinPaprikaListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinPaprikaListState(
                        error = result.message ?: "Something went wrong, check your network"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinPaprikaListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
