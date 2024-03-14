
class MyClass {
  fun myMethod() {
    println("myMethod")
  }
}

// This function extended the Int class with a new method called doubleIt.
// Of course, the Int class is a built-in class in Kotlin
fun Int.doubleIt(): Int  {
  return this * 2
}

fun String.removeFirstLastChar(): String {
  return this.substring(1, this.length - 1)
}

fun MyClass.idForMyClass(): Int {
  return 23
  // return Int.random()
}

fun main() {
  val num = 42.doubleIt()
  println("num is $num")

  val str = "Lehman".removeFirstLastChar()
  println("str is $str")

  val obj = MyClass()
  obj.myMethod()
  val id = obj.idForMyClass()
  println("id is $id")



}

