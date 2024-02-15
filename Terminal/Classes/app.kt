class Mansion : House() {

}
// a class is a blueprint for creating objects
// it describes the properties and behaviors of an object
open class House(val address: String = "123 Main St", val color: String = "White", val price: Double = 100000.0) {
  // constructor is a special function that is called when an object is created
  // it is used to initialize the object
  val tax: Double
  val taxValue: String
    get() {
      return "Your taxes are: $tax"
    }

  // init is a special block that is called when an object is created
  // it is used to initialize the object
  init {
    println("init called")
    tax = price * 0.10
  }

  fun calculateTax(): Double {
    return price * 0.10
  }

  // constructor(address: String) {
  //   this.address = address
  //   println("constructor with parameter called")
  // }

}

// this is main function
// it is the entry point of the program
fun main() {
  // House is a class
  // House() is an object
  // so house variable is an object of House class
  val house = House(address = "1 Broadway") // therefore, House() is calling the constructor of House class
  println(house.color)
  println(house.price)
  println(house.address)
  // house.tax = 100.0
  println(house.calculateTax())
  println(house.taxValue)

  val house2 = House("2 Broadway")
  println(house2.address)
  println(house2.taxValue)

  val house3 = House(price = 100.23)
  println(house3.address)
  println(house3.taxValue)
}

