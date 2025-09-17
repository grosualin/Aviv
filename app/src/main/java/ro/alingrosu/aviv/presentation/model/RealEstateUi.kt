package ro.alingrosu.aviv.presentation.model

data class RealEstateUi(
    val id: Int,
    val city: String,
    val price: Double,
    val area: Double,
    val imageUrl: String,
    val bedrooms: Int?,
    val rooms: Int?,
    val professional: String,
    val propertyType: String,
    val offerType: Int?
) {
    fun formattedPrice(): String {
        return "$price €"
    }
}