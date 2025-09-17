package ro.alingrosu.aviv.presentation.ui.screens.listing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun RealEstateListScreen(
    viewModel: RealEstateListViewModel = hiltViewModel(),
    onItemClick: (Int) -> Unit
) {
    val state by viewModel.state.collectAsState()
}