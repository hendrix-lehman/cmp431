package com.example.artspace

sealed class Screen(val route: String) {
  data object Home : Screen("home")
  data object Artist : Screen("artist")
}