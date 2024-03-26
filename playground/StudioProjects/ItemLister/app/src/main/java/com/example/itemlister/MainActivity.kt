package com.example.itemlister

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.itemlister.ui.theme.ItemListerTheme

const val TAG = "MY MAIN ACTIVITY"

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.i(TAG, "OnCreate started")
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
    Log.i(TAG, "OnStart called.")
  }

  override fun onResume() {
    super.onResume()
    Log.i(TAG, "OnResume called.")
  }

  override fun onPause() {
    super.onPause()
    Log.i(TAG, "OnPause called.")
  }

  override fun onStop() {
    super.onStop()
    Log.i(TAG, "OnStop called.")
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(TAG, "OnDestroy called.")
  }
}

@Composable
fun FancyNumber(modifier: Modifier, number: Int) {
  Log.d(TAG, "the parameter number is equal to $number")
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
  Log.d(TAG, "listing ${numbers.size} numbers")

  if (numbers.size > 1000)
    Log.w(TAG, "numbers (${numbers.size}) is greater than 1,000")

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