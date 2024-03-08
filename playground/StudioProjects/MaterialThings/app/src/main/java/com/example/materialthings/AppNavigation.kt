package com.example.materialthings

sealed class Screen(val route: String) {
  data object ScreenOne : Screen("1")
  data object ScreenTwo : Screen("2")
  data object ScreenThree : Screen("3")
}