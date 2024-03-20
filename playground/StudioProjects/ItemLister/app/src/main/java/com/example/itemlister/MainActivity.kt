package com.example.itemlister

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.tooling.preview.Preview
import com.example.itemlister.ui.theme.ItemListerTheme


class MainActivity : ComponentActivity() {

  val TAG = "MainActivity"


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    println("ON CREATE")
    Log.d(TAG, "OnCreate started")
    setContent {
      ItemListerTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

          NumberList()
        }
      }
    }
  }

  override fun onStart() {
    super.onStart()
    println("ON START")
  }

  override fun onResume() {
    super.onResume()
    println("ON RESUME")
  }

  override fun onPause() {
    super.onPause()
    println("ON PAUSE")
  }

  override fun onStop() {
    super.onStop()
    println("ON STOP")
  }

  override fun onDestroy() {
    super.onDestroy()
    println("ON DESTROY")
  }
}

@Composable
fun FancyNumber(modifier: Modifier, number: Int) {
  Card(
    modifier = modifier
  ) {
    Text(text = "Text $number")
  }
}

@Composable
fun NumberList(modifier: Modifier = Modifier) {
  // bad practice
  // we are doing logic work here BUT,
  // this is user interface (UI) related stuff
  // not a good separation of concerns
  val numbers = (1..100000).toList()

  LazyColumn {
    items(numbers) { number ->
      FancyNumber(modifier = modifier, number = number)
    }
  }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  ItemListerTheme {
  }
}