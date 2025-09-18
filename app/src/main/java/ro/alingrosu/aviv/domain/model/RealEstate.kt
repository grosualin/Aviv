package ro.alingrosu.aviv.domain.model

data class RealEstate(
    val id: Int,
    val city: String,
    val price: Double,
    val area: Double,
    val imageUrl: String? = null,
    val bedrooms: Int? = null,
    val rooms: Int? = null,
    val professional: String? = null,
    val propertyType: String? = null,
    val offerType: Int? = null
)