package pe.isil.easyshoes.data.remote

import pe.isil.easyshoes.domain.entities.Shoe

data class ShoeDto(
    val id: Int,
    val name: String,
    val brand: String,
    val price: Int,
    val image: String,
    val description: String
) {
    fun toDomain(): Shoe {
        return Shoe(
            id = id,
            name = name,
            brand = brand,
            price = price,
            image = image,
            description = description)
    }
}
