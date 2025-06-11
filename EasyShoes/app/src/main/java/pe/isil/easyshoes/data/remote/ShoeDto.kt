package pe.isil.easyshoes.data.remote

import com.google.gson.annotations.SerializedName
import pe.isil.easyshoes.domain.entities.Shoe
import pe.isil.easyshoes.domain.entities.ShoeSize

data class ShoeDto(
    val id: Int,
    val name: String,
    val brand: String,
    val price: Int,
    val image: String,
    val description: String,
    @SerializedName("sizes_available")
    val sizes: List<ShoeSizeDto>
) {
    fun toDomain(): Shoe {
        return Shoe(
            id = id,
            name = name,
            brand = brand,
            price = price,
            image = image,
            description = description,
            sizes = sizes.map { it.toDomain() }
        )
    }
}

data class ShoeSizeDto(
    val size: Double,
    @SerializedName("quantity")
    val stock: Int
) {
    fun toDomain(): ShoeSize {
        return ShoeSize(
            size = size,
            stock = stock
        )
    }
}