package ro.alingrosu.aviv.presentation.ui.screens.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ro.alingrosu.aviv.domain.usecase.RealEstateUseCase
import ro.alingrosu.aviv.presentation.model.RealEstateUi
import ro.alingrosu.aviv.presentation.state.UiState
import javax.inject.Inject

@HiltViewModel
class RealEstateDetailViewModel @Inject constructor(
    private val realEstateUseCase: RealEstateUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<RealEstateUi>>(UiState.Loading)
    val state: StateFlow<UiState<RealEstateUi>> = _state
}