package ro.alingrosu.aviv.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RealEstateListResponseDto(
    @SerializedName("items")
    val items: List<RealEstateDto>,

    @SerializedName("totalCount")
    val totalCount: Int
)