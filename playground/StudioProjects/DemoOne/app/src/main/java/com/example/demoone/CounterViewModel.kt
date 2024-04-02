package com.example.demoone

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
  var count = 0

  fun add() {
    count++
  }
}