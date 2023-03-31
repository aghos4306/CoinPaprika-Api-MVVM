package com.aghogho.coinpaprikaapirxjavamvvm.data.repository

import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.CoinPaprikaApi
import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.CoinPaprikaDto
import com.aghogho.coinpaprikaapirxjavamvvm.data.remote.dto.coindetails.*
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CoinPaprikaRepositoryImplTest {

    private val coinOne = CoinPaprikaDto(
        id = "1", isActive = false, name = "Bitcoin",
        rank = 1, symbol = "BTC", isNew = false, type = "Coin"
    )
    private val coinTwo = CoinPaprikaDto(id = "2", isActive = false,
        name = "Etherium", rank = 2, symbol = "ETH",
        isNew = false, type = "Coin"
    )

    private val coinThree = CoinPaprikaDto(id = "3", isActive = true,
        name = "Tether", rank = 5, symbol = "THE",
        isNew = false, type = "Coin"
    )

    private val coinDetail = CoinDetailDto(
        description = "hottest coin", development_status = "completed", first_data_at = "2nd March 2014", hardware_wallet = false,
        hash_algorithm = "algorithm", id = "1", is_new = false, isActive = false, last_data_at = "2nd March 2018",
        links_extended = listOf(
            LinksExtended(
                stats = Stats(1, 4, 3, 40),
                type = "coin",
                url = "www.coin.com",
            ),
        ),
        message = "coin", name = "coin", open_source = false,
        org_structure = "flat", proof_type = "pos", rank = 1, started_at = "2nd March 2010", symbol = "BRC",
        tags = listOf(Tag(coin_counter = 1, ico_counter = 2, id = "1", name = "BRC")),
        team = listOf(),
        type = "coin",
        whitepaper = Whitepaper(link = "whitepaper.com", "white"),
        links = Links(explorer = listOf("explorer"), facebook = listOf("facebook"), reddit = listOf("reddit"),
            source_code = listOf("source_code"), website = listOf("www.coin.com"), youtube = listOf("youtube.com"))
    )
    private val listOfCoins = listOf<CoinPaprikaDto>(coinOne, coinTwo, coinThree)

    @Mock
    lateinit var coinPaprikaApi: CoinPaprikaApi

    private lateinit var coinPaprikaRepositoryImpl: CoinPaprikaRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        coinPaprikaRepositoryImpl = CoinPaprikaRepositoryImpl(coinPaprikaApi)
    }

    @Test
    fun `getAllCoins() should return list of all Coins from api`() = runBlocking {
        val expectedResult = listOfCoins
        whenever(coinPaprikaRepositoryImpl.getAllCoins()).thenReturn(listOfCoins)
        val result = coinPaprikaRepositoryImpl.getAllCoins()
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun `getCoinById() should return specific coin detail content`() = runBlocking {
        val expectedResult = coinDetail
        whenever(coinPaprikaRepositoryImpl.getCoinById("1")).thenReturn(coinDetail)
        val result = coinPaprikaRepositoryImpl.getCoinById("1")
        Assert.assertEquals(expectedResult, result)
    }

}
