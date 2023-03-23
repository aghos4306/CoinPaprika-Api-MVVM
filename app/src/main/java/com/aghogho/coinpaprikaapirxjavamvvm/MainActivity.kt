package com.aghogho.coinpaprikaapirxjavamvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aghogho.coinpaprikaapirxjavamvvm.presentation.coin_detail_screen.CoinPaprikaDetailScreen
import com.aghogho.coinpaprikaapirxjavamvvm.presentation.coin_paprika_list.CoinPaprikaListScreen
import com.aghogho.coinpaprikaapirxjavamvvm.presentation.Screen
import com.aghogho.coinpaprikaapirxjavamvvm.ui.theme.CoinpaprikaApiRxJavaMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinpaprikaApiRxJavaMVVMTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinPaprikaListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinPaprikaListScreen.route
                        ) {
                            CoinPaprikaListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinPaprikaDetailScreen.route + "/{coinId}"
                        ) {
                            CoinPaprikaDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoinpaprikaApiRxJavaMVVMTheme {
        Greeting("Android")
    }
}
