package ro.alingrosu.aviv.presentation.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ro.alingrosu.aviv.domain.usecase.RealEstateUseCase
import ro.alingrosu.aviv.presentation.mapper.toUi
import ro.alingrosu.aviv.presentation.model.RealEstateUi
import ro.alingrosu.aviv.presentation.ui.state.UiState
import javax.inject.Inject

@HiltViewModel
class RealEstateDetailViewModel @Inject constructor(
    private val realEstateUseCase: RealEstateUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<RealEstateUi>>(UiState.Loading)
    val state: StateFlow<UiState<RealEstateUi>> = _state

    fun loadDetails(id: Int) {
        viewModelScope.launch {
            _state.value = UiState.Loading
            try {
                val realEstate = realEstateUseCase.getListingDetail(id)
                _state.value = UiState.Success(realEstate.toUi())
            } catch (e: Exception) {
                _state.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}