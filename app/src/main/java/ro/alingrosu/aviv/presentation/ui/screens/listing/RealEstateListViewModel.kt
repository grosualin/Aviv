package ro.alingrosu.aviv.presentation.ui.screens.listing

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ro.alingrosu.aviv.domain.usecase.RealEstateUseCase
import ro.alingrosu.aviv.presentation.model.RealEstateUi
import ro.alingrosu.aviv.presentation.ui.state.UiState
import javax.inject.Inject

@HiltViewModel
class RealEstateListViewModel @Inject constructor(
    private val realEstateUseCase: RealEstateUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<RealEstateUi>>>(UiState.Loading)
    val state: StateFlow<UiState<List<RealEstateUi>>> = _state
}