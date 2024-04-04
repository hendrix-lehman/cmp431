package com.example.viewmodeldemo.data

// ViewModel make calls to the repository to update the UI state
class AppRepository {

  // assume that this is connecting to a database or service to obtain number
  fun getLuckyNumber(): Int {
    return (0..100).random()
  }

}