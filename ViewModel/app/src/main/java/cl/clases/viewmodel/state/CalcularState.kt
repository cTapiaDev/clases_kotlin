package cl.clases.viewmodel.state

data class CalcularState(
    val precio: String = "",
    val descuento: String = "",
    val totalPrecio: Double = 0.0,
    val totalDescuento: Double = 0.0,
    val showAlert: Boolean = false
)
