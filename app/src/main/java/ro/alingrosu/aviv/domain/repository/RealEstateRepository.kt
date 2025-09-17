package ro.alingrosu.aviv.domain.repository

import ro.alingrosu.aviv.domain.model.RealEstate

interface RealEstateRepository {
    suspend fun getListings(): List<RealEstate>
    suspend fun getListingDetail(id: Int): RealEstate
}