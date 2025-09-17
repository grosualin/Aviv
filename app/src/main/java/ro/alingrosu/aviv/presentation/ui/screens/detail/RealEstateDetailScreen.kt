package ro.alingrosu.aviv.presentation.ui.screens.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun RealEstateDetailScreen(
    realEstateId: Int,
    viewModel: RealEstateDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
}