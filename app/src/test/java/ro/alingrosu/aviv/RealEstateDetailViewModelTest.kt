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
import ro.alingrosu.aviv.presentation.ui.screens.detail.RealEstateDetailViewModel
import ro.alingrosu.aviv.presentation.ui.screens.listing.RealEstateListViewModel
import ro.alingrosu.aviv.presentation.ui.state.UiState

@OptIn(ExperimentalCoroutinesApi::class)
class RealEstateDetailViewModelTest {

    private val realEstateUseCase: RealEstateUseCase = mockk()
    private lateinit var viewModel: RealEstateDetailViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = RealEstateDetailViewModel(realEstateUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadDetails emits Loading then Success state when useCase returns data`() = runTest {
        val realEstate = RealEstate(1, "Paris", 1000000.0, 120.0)
        coEvery { realEstateUseCase.getListingDetail(1) } returns realEstate

        viewModel.loadDetails(1)

        assert(viewModel.state.value is UiState.Loading)

        advanceUntilIdle()

        val state = viewModel.state.value
        assert(state is UiState.Success)
        assert(1 == (state as UiState.Success).data.id)
    }

    @Test
    fun `loadDetails emits Loading then Error state when useCase throws exception`() = runTest {
        coEvery { realEstateUseCase.getListingDetail(1) } throws RuntimeException("Network error")

        viewModel.loadDetails(1)

        assert(viewModel.state.value is UiState.Loading)

        advanceUntilIdle()

        val state = viewModel.state.value
        assert(state is UiState.Error)
        assert("Network error" == (state as UiState.Error).message)
    }
}
