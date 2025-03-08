package cl.bootcamp.kotlinconsola

fun main() {
    suma(10, 15)

    val resDiv = division(10.5, 2.0)
    println(resDiv)

    // Funcion Lambda
    val sum = { num1: Int, num2: Int -> println(num1 + num2) }

    val resultado = sum(12, 12)


}

fun suma(num1: Int, num2: Int): Unit {
    val res = num1 + num2
    println("Resultado: $res")
}

fun division (num1: Double, num2: Double): Double {
    val res = num1 / num2
    return res
}