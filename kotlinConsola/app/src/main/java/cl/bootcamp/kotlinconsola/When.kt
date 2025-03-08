package cl.bootcamp.kotlinconsola

fun main() {

    var dia = 7

    when (dia) {
        1 -> println("Lunes")
        2 -> println("Martes")
        3 -> println("Miercoles")
        4 -> println("Jueves")
        5 -> println("Viernes")
        else -> println("El dia no se encontró")
    }

    val x = 5
    when (x) {
        in 1..10 -> println("En el grupo 1")
        in 11..20 -> println("En el grupo 2")
        else -> println("No está en ningun grupo")
    }

}