package com.aghogho.coinpaprikaapirxjavamvvm.data.repository

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.CoinPaprikaApi
import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.coindetails.TeamMember
import com.aghogho.coinpaprikaapirxjavamvvm.domain.model.CoinPaprika
import com.aghogho.coinpaprikaapirxjavamvvm.domain.model.CoinPaprikaDetail
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CoinPaprikaRepositoryImplTest {

    private val coinOne = CoinPaprika(id = "1", isActive = false, name = "Bitcoin", rank = 1, symbol = "BTC")
    private val coinTwo = CoinPaprika(id = "2", isActive = false, name = "Etherium", rank = 2, symbol = "ETH")
    private val coinDetail = CoinPaprikaDetail(
        coinId = "1",
        name = "Bitcoin",
        description = "One of the largest crypto coins",
        symbol = "BTC",
        rank = 1,
        isActive = false,
        tags = listOf("BlockChain", "Defi"),
        team = listOf(TeamMember("1", "Satochi", "Founder"))
    )
    private val listOfCoins = listOf<CoinPaprika>(coinOne, coinTwo)

    @Mock
    lateinit var coinPaprikaApi: CoinPaprikaApi

    private lateinit var classUnderTest: CoinPaprikaRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        classUnderTest = CoinPaprikaRepositoryImpl(coinPaprikaApi)
    }

    @Test
    fun `getAllCoins() should return list of all Coins from api`() = runBlocking {
        val expectedResult = listOfCoins
        whenever(classUnderTest.getAllCoins()).thenReturn(listOfCoins)
        val result = classUnderTest.getAllCoins()
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun `getCoinById() should return specific coin detail content`() = runBlocking {
        val expectedResult = coinDetail
        whenever(classUnderTest.getCoinById("1")).thenReturn(coinDetail)
        val result = classUnderTest.getCoinById("1")
        Assert.assertEquals(expectedResult, result)
    }

}
