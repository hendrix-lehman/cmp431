
var username = ""
var password = ""

// step 0
fun userProvidedTwoArguments(args: Array<String>) : Boolean{
  if (args.size < 2 || args.size > 2) {
    println("Please provide a username and password as command-line arguments in that order")
    return false
  }
  return true
}

// step 1
fun obtainUsernameAndPassword(args: Array<String>) {
  username = args[0]
  password = args[1]
}

fun isUsernameAndPasswordValid(username: String = "", password: String = "") : Boolean {
  return username == "admin" && password == "admin"
}

// TEST CASES
// fun testUserProvidedTwoArguments_EmptyArray() {
//   val args = arrayOf<String>()
//   assert(!userProvidedTwoArguments(args))
// }

fun main(args: Array<String>) {

  testUserProvidedTwoArguments_EmptyArray()
  if (userprovidedtwoarguments(args)) {
    obtainusernameandpassword(args)
    if (!isusernameandpasswordvalid(username, password)) {
      println("invalid username or password")
      return
    }

    // login successful
    println("welcome, $username!")
  }
}
