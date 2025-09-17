package ro.alingrosu.aviv.presentation.ui.screens.listing

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import ro.alingrosu.aviv.presentation.ui.state.UiState
import ro.alingrosu.aviv.presentation.ui.theme.Typography

@Composable
fun RealEstateListScreen(
    viewModel: RealEstateListViewModel = hiltViewModel(),
    onItemClick: (Int) -> Unit
) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        when (state) {
            is UiState.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Success -> {
                val listings = (state as UiState.Success).data
                LazyColumn(modifier = Modifier.padding(8.dp)) {
                    items(listings) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable { onItemClick(item.id) }
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text(text = "${item.propertyType} - ${item.city}", style = Typography.titleMedium)
                                Text(text = "${item.formattedArea()} - ${item.formattedPrice()}")
                            }
                        }
                    }
                }
            }

            is UiState.Error -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = (state as UiState.Error).message, color = Color.Red)
                }
            }
        }
    }
}