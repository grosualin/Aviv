package ro.alingrosu.aviv.domain.model

data class RealEstate(
    val id: Int,
    val city: String,
    val price: Double,
    val area: Double,
    val imageUrl: String?,
    val bedrooms: Int?,
    val rooms: Int?,
    val professional: String?,
    val propertyType: String?,
    val offerType: Int?
)