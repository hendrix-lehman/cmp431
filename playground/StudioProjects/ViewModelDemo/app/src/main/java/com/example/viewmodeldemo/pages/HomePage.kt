package com.example.viewmodeldemo.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HomePage(modifier: Modifier = Modifier) {
  // here we build the home page by laying out each part (component)
  Column {
    PageTitle()
//    LuckyNumberCard(number = homeViewModel.luckyNumber) {
//      homeViewModel.getLuckyNumber()
//    }
  }
}

@Composable
fun PageTitle(modifier: Modifier = Modifier) {
  Text(text = "Home Page")
}

@Composable
fun LuckyNumberCard(number: Int, change: () -> Unit) {
  Card {
    Text(text = "Your lucky number is $number")
    Button(onClick = change) {
      Text(text = "Get new lucky number")
    }

  }
}