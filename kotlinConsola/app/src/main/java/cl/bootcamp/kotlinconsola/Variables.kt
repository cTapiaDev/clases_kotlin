package cl.bootcamp.kotlinconsola

fun main() {
    // print("Hola mundo!")

    var nombre = "Jorge"
    nombre = "Jose"
    var num : Int = 1234

    val apellido = "Ruiz"

    // Null Safety
    var texto : String? = null

    var num2 = "5".toInt()
    var num3 = 10

    var suma = num2 + num3
    println("Suma: $suma")

    // Try-Catch
    try {
        println("Ingresa el primer numero")
        var n1 = readln().toInt()

        println("Ingresa un segundo numero")
        var n2 = readln().toInt()

        var sum = n1 + n2
        println("Resultado: $sum")

    } catch (e: NumberFormatException) {
        print("Error: ingresa un dato valido")
    }


}