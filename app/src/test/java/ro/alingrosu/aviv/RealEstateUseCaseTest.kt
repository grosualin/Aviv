package ro.alingrosu.aviv

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import ro.alingrosu.aviv.domain.model.RealEstate
import ro.alingrosu.aviv.domain.repository.RealEstateRepository
import ro.alingrosu.aviv.domain.usecase.RealEstateUseCase

@OptIn(ExperimentalCoroutinesApi::class)
class RealEstateUseCaseTest {

    private val repository: RealEstateRepository = mockk()
    private lateinit var realEstateUseCase: RealEstateUseCase

    @Before
    fun setup() {
        realEstateUseCase = RealEstateUseCase(repository)
    }

    @Test
    fun `getListings should return list from repository`() = runTest {
        val listings = listOf(RealEstate(1, "Paris", 1000000.0, 120.0))
        coEvery { repository.getListings() } returns listings

        val result = realEstateUseCase.getListings()

        assert(1 == result.size)
        assert("Paris" == result[0].city)
        coVerify(exactly = 1) { repository.getListings() }
    }
}
