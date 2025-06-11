package pe.isil.easyshoes.features.cart.domain

data class CartItem(
    val id: Int,
    val name: String,
    val image: String,
    val price: Int,
    val quantity: Int
)