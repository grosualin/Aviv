package ro.alingrosu.aviv.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alingrosu.aviv.domain.model.RealEstate

interface RealEstateRepository {
    fun getListings(): Flow<List<RealEstate>>
    fun getListingDetail(id: Int): Flow<RealEstate>
}