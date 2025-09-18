package ro.alingrosu.aviv

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import ro.alingrosu.aviv.domain.model.RealEstate
import ro.alingrosu.aviv.domain.usecase.RealEstateUseCase
import ro.alingrosu.aviv.presentation.ui.screens.listing.RealEstateListViewModel
import ro.alingrosu.aviv.presentation.ui.state.UiState

@OptIn(ExperimentalCoroutinesApi::class)
class RealEstateListViewModelTest {

    private val realEstateUseCase: RealEstateUseCase = mockk()
    private lateinit var viewModel: RealEstateListViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = RealEstateListViewModel(realEstateUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadListings emits Loading then Success state when useCase returns data`() = runTest {
        val listings = listOf(RealEstate(1, "Paris", 1000000.0, 120.0))
        coEvery { realEstateUseCase.getListings() } returns listings

        viewModel.loadListings()

        assert(viewModel.state.value is UiState.Loading)

        advanceUntilIdle()

        val state = viewModel.state.value
        assert(state is UiState.Success)
        assert(1 == (state as UiState.Success).data.size)
    }

    @Test
    fun `loadListings emits Loading then Error state when useCase throws exception`() = runTest {
        coEvery { realEstateUseCase.getListings() } throws RuntimeException("Network error")

        viewModel.loadListings()

        assert(viewModel.state.value is UiState.Loading)

        advanceUntilIdle()

        val state = viewModel.state.value
        assert(state is UiState.Error)
        assert("Network error" == (state as UiState.Error).message)
    }
}
