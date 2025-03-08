package cl.bootcamp.kotlinconsola

class Personas {

    private var nombre = ""
    private var edad = 0

    // Constructor secundario
    constructor(nombre: String, edad: Int) {
        this.nombre = nombre
        this.edad = edad
    }

    fun saludar() {
        println("Hola me llamo ${this.nombre} y tengo ${this.edad} años.")
    }

}

// Constructor primario
class Usuarios(
    private var nombre: String,
    private var email: String
) {
    fun login() {
        println("Login con user: ${this.nombre}, email: ${this.email}")
    }
}

fun main() {
    val persona = Personas("Jorge", 30)
    persona.saludar()

    val user = Usuarios("Pedro", "pedro@gmail.com")
    user.login()
}