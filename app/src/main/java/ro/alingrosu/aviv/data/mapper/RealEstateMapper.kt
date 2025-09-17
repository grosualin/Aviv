package ro.alingrosu.aviv.data.mapper

import ro.alingrosu.aviv.data.remote.dto.RealEstateDto
import ro.alingrosu.aviv.domain.model.RealEstate

fun RealEstateDto.toDomain() = RealEstate(
    id = id,
    bedrooms = bedrooms,
    city = city ?: "",
    area = area ?: 0.0,
    imageUrl = url,
    price = price ?: 0.0,
    professional = professional,
    propertyType = propertyType,
    offerType = offerType,
    rooms = rooms
)