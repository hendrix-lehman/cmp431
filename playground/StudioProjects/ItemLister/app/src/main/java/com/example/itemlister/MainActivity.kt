package com.example.itemlister

import android.os.Bundle
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
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ItemListerTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

          NumberList()
        }
      }
    }
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