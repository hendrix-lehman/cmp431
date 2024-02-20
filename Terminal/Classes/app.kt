// a Mansion "is-a" House
// a Mansion "has-a" backyard
// a Mansion "has-a" pool
// a Mansion "has-a" tax implications
class Mansion : House(), TaxInterface, BackyardInterface, PoolInterface {
  override val backyard: Boolean = true
  override val pool: Boolean = true
  override var tax: Double = 40000.0
  override fun calculateTax(): Double {
    return tax * 0.40
  }
}

abstract class Building {
  abstract val address: String
  abstract val color: String
  abstract val price: Double
}

// when talking about interfaces, we use "implements" keyword to say that the class implements the interface
interface TaxInterface {
  var tax: Double
  fun calculateTax(): Double
}

interface BackyardInterface {
  val backyard: Boolean
} 

interface PoolInterface {
  val pool: Boolean
}

// a House "is-a" Building
// a class is a blueprint for creating objects
// it describes the properties and behaviors of an object
open class House(override val address: String = "123 Main St", override val color: String = "White", override val price: Double = 100000.0): Building(), TaxInterface {
  // constructor is a special function that is called when an object is created
  // it is used to initialize the object
  override var tax: Double = 10000.0
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

  override fun calculateTax(): Double {
    return price * 0.10
  }

  // constructor(address: String) {
  //   this.address = address
  //   println("constructor with parameter called")
  // }

}

// Extending Functions
fun Mansion.isPartyHouse(): Boolean {
  return this.backyard && this.pool
}

fun String.Upper(): String {
  return this.toUpperCase()
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

  println("---Abstract/Interfaces------")

  val mansion = Mansion()
  println(mansion.toString())
  println(mansion.address)
  println(mansion.taxValue)

  println("-----Extending Functions--------")
  println("Is the mansion a party house? ${mansion.isPartyHouse()}")
  println("Hello".Upper())

}

