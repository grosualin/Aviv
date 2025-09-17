package ro.alingrosu.aviv.data.remote.service

import retrofit2.http.GET
import retrofit2.http.Path
import ro.alingrosu.aviv.data.remote.dto.RealEstateDto
import ro.alingrosu.aviv.data.remote.dto.RealEstateListResponseDto

interface RealEstateApi {

    @GET("listings.json")
    suspend fun getListings(): RealEstateListResponseDto

    @GET("listings/{listingId}.json")
    suspend fun getListingDetail(@Path("listingId") id: Int): RealEstateDto

}