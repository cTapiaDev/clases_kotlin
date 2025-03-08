package cl.bootcamp.kotlinconsola

fun main() {

    val lista = listOf(1, 2, 3, 4, 5)
    println(lista)
    println(lista[1])

    val usuarios = mutableListOf(1, 2, 3)

    usuarios.add(4)
    println(usuarios)
    usuarios.add(8)
    println(usuarios)

    usuarios.remove(2)
    println(usuarios)
}