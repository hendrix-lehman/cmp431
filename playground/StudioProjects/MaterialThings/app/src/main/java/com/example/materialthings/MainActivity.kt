package com.example.materialthings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.materialthings.ui.theme.MaterialThingsTheme

class MainActivity : ComponentActivity() {

  // This is the first thing that runs when our program starts.
  // Sort of a main function to begin our app
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberNavController()
      MaterialThingsTheme {
        NavHost(
          navController = navController,
          startDestination = Screen.ScreenOne.route + "/{param}"
        ) {
          // a graph is really each destination
          composable(
            route = Screen.ScreenOne.route + "/{param}",
            arguments = listOf(navArgument("param") { type = NavType.StringType })
          ) {
            ScreenOne(navController = navController)
          }

          composable(
            route = Screen.ScreenTwo.route + "/{abc}",
            arguments = listOf(navArgument("abc") { type = NavType.IntType })
          ) {
            ScreenTwo(navController = navController)
          }

          composable(
            route = Screen.ScreenThree.route + "/{xyz}",
            arguments = listOf(navArgument("xyz") { type = NavType.BoolType })
          ) {
            ScreenThree(navController = navController)
          }

        }

      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenOne(navController: NavController) {
  val param = navController.currentBackStackEntry?.arguments?.getString("param") ?: "UNK"
  val luckyNumber = 23
  val thisIsFun = true
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column(
            modifier = Modifier
              .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {

            Row {
              Text(text = "This is ScreenOne - $param")
            }
          }
        }
      )
    },

    ) { it ->
    Column(
      modifier = Modifier.padding(it)
    )
    {
      Text(text = "Hello")
      Text(text = "World")
      Button(onClick = {
        navController.navigate(Screen.ScreenTwo.route + "/$luckyNumber")
      }) {
        Text(text = "Go to ScreenTwo")
      }
      Button(onClick = {
        navController.navigate(Screen.ScreenThree.route + "/$thisIsFun")
      }) {
        Text(text = "Go to Screen 3")
      }
    }
  }
}

@Composable
fun ScreenTwo(navController: NavController) {
  val num = navController.currentBackStackEntry?.arguments?.getInt("abc") ?: -1
  val param = "screen2"

  Column {
    Text(text = "Hi, there! - num: $num")
    Button(onClick = {
//      navController.popBackStack()
      navController.navigate(Screen.ScreenOne.route + "/$param")
    }) {
      Text(text = "Go Back to caller Screen")
    }
  }
}

@Composable
fun ScreenThree(navController: NavController) {
  val isFun = navController.currentBackStackEntry?.arguments?.getBoolean("xyz")
  val param = "screen3"
  val num = 8
  Column {
    Text(text = "Screen 3 - $isFun")
    Button(onClick = {
      navController.navigate(Screen.ScreenTwo.route + "/$num")
    }) {
      Text(text = "Go to Screen Two")
    }
    Button(onClick = {
      navController.navigate(Screen.ScreenOne.route + "/$param")
    }) {
      Text(text = "Go to Screen One")
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    color = MaterialTheme.colorScheme.primary,
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  MaterialThingsTheme {
    Greeting("Android")
  }
}