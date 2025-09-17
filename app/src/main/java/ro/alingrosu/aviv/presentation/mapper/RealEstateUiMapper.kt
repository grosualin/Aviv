package ro.alingrosu.aviv.presentation.mapper

import ro.alingrosu.aviv.domain.model.RealEstate
import ro.alingrosu.aviv.presentation.model.RealEstateUi


fun RealEstate.toUi() = RealEstateUi(
    id = id,
    bedrooms = bedrooms ?: 0,
    city = city,
    area = area,
    imageUrl = imageUrl ?: "",
    price = price,
    professional = professional ?: "",
    propertyType = propertyType ?: "",
    offerType = offerType ?: 0,
    rooms = rooms ?: 0
)