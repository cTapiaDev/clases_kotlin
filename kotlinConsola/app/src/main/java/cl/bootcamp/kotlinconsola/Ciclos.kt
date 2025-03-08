package cl.bootcamp.kotlinconsola

fun main() {

    // for (i in 1..5) {
       // println(i)
    // }

   /* for (a in 'a'..'f') {
        println(a)
    }

    for (a in 'f' downTo 'a') {
        println(a)
    }

    for (i in 5 downTo 1) {
        println(i)
    } */

    val users = arrayOf("Luis", "Ramon", "Laura", "Diego")
    for (user in users.indices) {
        println("[$user, ${users[user]}]")
    }

    // Foreach

    val list = listOf(1, 2, 3, 4, 5)
    list.forEach { println(it) }

    list.forEachIndexed { index, i -> println("Posicion: $index - valor: $i") }

}