class NoSingleton(var name: String) {
    fun print() {
        println("NoSingleton: name: $name")
    }
}

object Singleton {
  var name: String = "singleton"

  init {
    println("Singleton created")
  }

  fun print() {
      println("Singleton: name: $name")
  }
}



fun main() {
    val noSingleton1 = NoSingleton("noSingleton1")
    val noSingleton2 = NoSingleton("noSingleton2")

    noSingleton1.print()
    noSingleton2.print()

    noSingleton2.name = "noSingleton2 changed"
    noSingleton1.print()
    noSingleton2.print()

    // val singleton1 = Singleton()
    // val singleton2 = Singleton()
    Singleton.print()
    Singleton.name = "singleton changed"
    Singleton.print()
}

