package ro.alingrosu.aviv.presentation.ui.screens.listing

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
class RealEstateListViewModel @Inject constructor(
    private val realEstateUseCase: RealEstateUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<RealEstateUi>>>(UiState.Loading)
    val state: StateFlow<UiState<List<RealEstateUi>>> = _state

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    private var isFirstLoad = true


    init {
        loadListings()
    }

    fun loadListings() {
        viewModelScope.launch {
            if (isFirstLoad)
                _state.value = UiState.Loading
            _isRefreshing.value = !isFirstLoad
            try {
                val listings = realEstateUseCase.getListings()
                _state.value = UiState.Success(listings.map { it.toUi() })
            } catch (e: Exception) {
                _state.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            } finally {
                _isRefreshing.value = false
                isFirstLoad = false
            }
        }
    }
}