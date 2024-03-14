enum class VehicleType {
    CAR, TRUCK, ELECTRIC, VAN, MOTORBIKE
}

class Vehicle<T>(val someTypeOfCar: T, val type: VehicleType) {

  fun getCar(): T {
    return someTypeOfCar
  }

  fun showVehicleType() {
    if (type == VehicleType.CAR) {
      println("This is a car")
    }else if (type == VehicleType.TRUCK) {
      println("This is a truck")
    } else if (type == VehicleType.ELECTRIC) {
      println("This is an electric car")
    } else if (type == VehicleType.VAN) {
      println("This is a van")
    } else if (type == VehicleType.MOTORBIKE) {
      println("This is a motorbike")
    }
  }
}

fun main() {
    val car = Vehicle("Toyota", VehicleType.CAR)
    car.showVehicleType()
    println(car.getCar().javaClass)

    val truck = Vehicle(1, VehicleType.TRUCK)
    truck.showVehicleType()
    println(truck.getCar().javaClass)
}
