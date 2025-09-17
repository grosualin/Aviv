package ro.alingrosu.aviv.data.repository

import kotlinx.coroutines.delay
import ro.alingrosu.aviv.data.mapper.toDomain
import ro.alingrosu.aviv.data.remote.service.RealEstateApi
import ro.alingrosu.aviv.domain.model.RealEstate
import ro.alingrosu.aviv.domain.repository.RealEstateRepository
import javax.inject.Inject

class RealEstateRepositoryImpl @Inject constructor(
    private val api: RealEstateApi
) : RealEstateRepository {

    override suspend fun getListings(): List<RealEstate> {
        return api.getListings().items.map { it.toDomain() }
    }

    override suspend fun getListingDetail(id: Int): RealEstate {
        return api.getListingDetail(id).toDomain()
    }
}