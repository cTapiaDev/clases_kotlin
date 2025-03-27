package cl.clases.viewmodel.viewModels

import androidx.lifecycle.ViewModel

class CalcularViewModel: ViewModel() {

    fun calcular(precio: String, descuento: String): Pair<Double, Pair<Double, Boolean>> {
        var totalPrecio = 0.0
        var totalDescuento = 0.0
        var showAlert = false

        if (precio != "" && descuento != "") {
            totalPrecio = calcularPrecio(precio.toDouble(), descuento.toDouble())
            totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
        } else {
            showAlert = true
        }

        return Pair(totalPrecio, Pair(totalDescuento, showAlert))
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val result = precio * (1 - descuento / 100)
        return kotlin.math.round(result * 100) / 100.0
    }

    private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val result = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(result * 100) / 100.0
    }



}