package pe.isil.easyshoes.domain.entities

data class Shoe (
    val id: Int,
    val name: String,
    val brand: String,
    val price: Int,
    val image: String,
    val description: String
)