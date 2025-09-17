package ro.alingrosu.aviv.domain.usecase

import ro.alingrosu.aviv.domain.repository.RealEstateRepository
import javax.inject.Inject

class RealEstateUseCase @Inject constructor(
    private val repository: RealEstateRepository
) {
    suspend fun getListings() = repository.getListings()
    suspend fun getListingDetail(id: Int) = repository.getListingDetail(id)
}