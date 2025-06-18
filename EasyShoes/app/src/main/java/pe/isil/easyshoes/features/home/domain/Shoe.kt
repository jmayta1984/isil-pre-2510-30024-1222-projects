package pe.isil.easyshoes.features.home.domain

data class Shoe (
    val id: Int,
    val name: String,
    val brand: String,
    val price: Int,
    val image: String,
    val description: String,
    val sizes: List<ShoeSize>,
    val isFavorite: Boolean
)

data class ShoeSize (
    val size: Double,
    val stock: Int
)