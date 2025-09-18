package ro.alingrosu.aviv

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import ro.alingrosu.aviv.data.remote.dto.RealEstateDto
import ro.alingrosu.aviv.data.remote.dto.RealEstateListResponseDto
import ro.alingrosu.aviv.data.remote.service.RealEstateApi
import ro.alingrosu.aviv.data.repository.RealEstateRepositoryImpl

@OptIn(ExperimentalCoroutinesApi::class)
class RealEstateRepositoryImplTest {

    private lateinit var repository: RealEstateRepositoryImpl
    private val api: RealEstateApi = mockk()

    @Before
    fun setup() {
        repository = RealEstateRepositoryImpl(api)
    }

    @Test
    fun `getListings should return items from api`() = runTest {
        val response = RealEstateListResponseDto(
            items = listOf(
                RealEstateDto(id = 1, city = "Paris", price = 1000000.0, area = 120.0)
            ),
            totalCount = 1
        )
        coEvery { api.getListings() } returns response

        val result = repository.getListings()

        assert(1 == result.size)
        assert("Paris" == result[0].city)
        coVerify { api.getListings() }
    }
}
