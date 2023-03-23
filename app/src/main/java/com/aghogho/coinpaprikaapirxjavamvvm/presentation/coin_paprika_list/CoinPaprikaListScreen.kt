package com.aghogho.coinpaprikaapirxjavamvvm.presentation.coin_paprika_list

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aghogho.coinpaprikaapirxjavamvvm.presentation.Screen
import com.aghogho.coinpaprikaapirxjavamvvm.presentation.coin_paprika_list.component.CoinPaprikaListItem
import kotlinx.coroutines.launch

@Composable
fun CoinPaprikaListScreen(
    navController: NavController,
    viewModel: CoinPaprikaListViewModel = hiltViewModel(),

    animationDuration: Int = 100,
    scaleDown: Float = 0.9f
) {
    val interactionSource = MutableInteractionSource()
    val coroutineScope = rememberCoroutineScope()
    val scale = remember {
        androidx.compose.animation.core.Animatable(1f)
    }

    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

                .scale(scale = scale.value)
                .clickable(interactionSource = interactionSource, indication = null) {
                    coroutineScope.launch {
                        scale.animateTo(
                            scaleDown,
                            animationSpec = tween(animationDuration)
                        )
                        scale.animateTo(
                            1f,
                            animationSpec = tween(animationDuration)
                        )
                    }
                }


        ) {
            items(state.coins) { coin ->
                CoinPaprikaListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinPaprikaDetailScreen.route + "/${coin.id}")
                    }
                )
                Divider()
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
