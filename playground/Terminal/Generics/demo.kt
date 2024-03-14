class Vehicle<ABC>(val type: ABC) {


  fun doSomethingWithType() {
    if (type is String) {
      println("This is a string")
    } else if (type is Int) {
      println("This is an integer")
    } else if (type is Car) {
      println("This is a car")
    } else {
      println("Unknown type")
    }
  }
}

class Car(val name: String) {
  
}

fun main() {
    val vehicle = Vehicle<String>("Car")
    vehicle.doSomethingWithType()
    println(vehicle.type)

    // try to pass an integer
    val vehicle2 = Vehicle<Int>(10)
    vehicle2.doSomethingWithType()
    println(vehicle2.type)

    // try to pass an object
    val vehicle3 = Vehicle<Car>(Car("BMW"))
    vehicle3.doSomethingWithType()
    println(vehicle3.type.name)

    // try to pass a boolean
    val vehicle4 = Vehicle<Boolean>(true)
    vehicle4.doSomethingWithType()
    println(vehicle4.type)
}
