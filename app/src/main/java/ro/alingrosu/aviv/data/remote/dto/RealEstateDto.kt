package ro.alingrosu.aviv.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RealEstateDto(

    @SerializedName("id")
    val id: Int,

    @SerializedName("bedrooms")
    val bedrooms: Int? = null,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("area")
    val area: Double? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("price")
    val price: Double? = null,

    @SerializedName("professional")
    val professional: String? = null,

    @SerializedName("propertyType")
    val propertyType: String? = null,

    @SerializedName("offerType")
    val offerType: Int? = null,

    @SerializedName("rooms")
    val rooms: Int? = null
)