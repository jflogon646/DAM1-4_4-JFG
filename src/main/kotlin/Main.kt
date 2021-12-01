class Pila<T>() {

    var lista: MutableList<T> = mutableListOf<T>()

    constructor(listado: Collection<T>) : this() {
        this.lista = listado.toMutableList()
    }

    fun push(valor: T) {
        lista.add(0, valor)
    }

    fun pop(): Boolean {
        return if (lista.isEmpty()) {
            false
        } else {
            lista.remove(lista[0])
            true
        }
    }

    fun top(): T? {
        return if (lista.isNotEmpty()) {
            lista[0]
        } else {
            null
        }
    }

    fun estaVacia(): Boolean {
        return lista.isEmpty()
    }

    fun noEstaVacia(): Boolean {
        return lista.isNotEmpty()
    }

    fun tamanio(): Int {
        return lista.size
    }

    override fun toString(): String {
        return lista.toString()
    }

}
fun <T> reversa(lista: List<T>): List<T> {

    val pila = Pila<T>()
    val iterador = lista.iterator()
    val salida = mutableListOf<T>()

    while (iterador.hasNext()) {
        pila.push(iterador.next())
    }

    while (pila.noEstaVacia()) {
        pila.top()?.let { salida.add(it) }
        pila.pop()
    }


    return salida
}

fun main() {
    var numbers = listOf("one", "two", "three", "four")
    var numbersRev = reversa(numbers)
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
    else
        println("Correcto")
    println(numbersRev)
}