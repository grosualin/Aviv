package ro.alingrosu.aviv.presentation.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ro.alingrosu.aviv.R
import ro.alingrosu.aviv.presentation.ui.state.UiState
import ro.alingrosu.aviv.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RealEstateDetailScreen(
    realEstateId: Int,
    viewModel: RealEstateDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(realEstateId) {
        viewModel.loadDetails(realEstateId)
    }

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.detail_title)) }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            when (state) {
                is UiState.Loading -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }

                is UiState.Success -> {
                    val listing = (state as UiState.Success).data
                    Column(modifier = Modifier.padding(top = 16.dp)) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(listing.imageUrl)
                                .crossfade(true)
                                .placeholder(R.drawable.placeholder)
                                .error(R.drawable.placeholder)
                                .build(),
                            contentDescription = stringResource(R.string.image_content_description),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = listing.propertyType,
                                style = Typography.titleLarge,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Text(text = stringResource(R.string.city, listing.city))
                            Text(text = stringResource(R.string.bedrooms, listing.bedrooms))
                            Text(text = stringResource(R.string.rooms, listing.rooms))
                            Text(text = stringResource(R.string.area, listing.area))
                            Text(text = stringResource(R.string.price, listing.price))
                            Text(text = stringResource(R.string.professional, listing.professional))
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
}