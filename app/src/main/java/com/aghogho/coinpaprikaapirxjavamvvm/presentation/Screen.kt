package com.aghogho.coinpaprikaapirxjavamvvm.presentation

sealed class Screen(val route: String) {
    object CoinPaprikaListScreen: Screen("coin_paprika_list_screen")
    object CoinPaprikaDetailScreen: Screen("coin_paprika_detail_screen")
}
