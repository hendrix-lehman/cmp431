package com.example.materialthings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialthings.ui.theme.MaterialThingsTheme

class MainActivity : ComponentActivity() {

  // This is the first thing that runs when our program starts.
  // Sort of a main function to begin our app
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberNavController()
      MaterialThingsTheme {
        NavHost(navController = navController, startDestination = "1") {
          // a graph is really each destination

          composable("1") {
            Text(
              modifier = Modifier.clickable { navController.navigate("2") },
              text = "Destination 1"
            )
          }
          composable(route = "2") {
            Text(
              modifier = Modifier.clickable { navController.navigate("1") },
              text = "Destination 2"
            )
          }
        }

      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialThingsApp(modifier: Modifier = Modifier) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {

            Row {
              Text(text = "This Title")
              Text(text = "AND")
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