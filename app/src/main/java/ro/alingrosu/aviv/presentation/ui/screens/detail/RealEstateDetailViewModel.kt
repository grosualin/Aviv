package ro.alingrosu.aviv.presentation.ui.screens.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ro.alingrosu.aviv.domain.usecase.RealEstateUseCase
import javax.inject.Inject

@HiltViewModel
class RealEstateDetailViewModel @Inject constructor(
    private val realEstateUseCase: RealEstateUseCase
) : ViewModel() {}