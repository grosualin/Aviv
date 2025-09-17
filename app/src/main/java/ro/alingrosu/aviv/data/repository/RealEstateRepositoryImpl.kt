package ro.alingrosu.aviv.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ro.alingrosu.aviv.data.mapper.toDomain
import ro.alingrosu.aviv.data.remote.service.RealEstateApi
import ro.alingrosu.aviv.domain.model.RealEstate
import ro.alingrosu.aviv.domain.repository.RealEstateRepository
import javax.inject.Inject

class RealEstateRepositoryImpl @Inject constructor(
    private val api: RealEstateApi
) : RealEstateRepository {

    override fun getListings(): Flow<List<RealEstate>> = flow {
        val response = api.getListings().items.map { it.toDomain() }
        emit(response)
    }

    override fun getListingDetail(id: Int): Flow<RealEstate> = flow {
        val response = api.getListingDetail(id).toDomain()
        emit(response)
    }

}