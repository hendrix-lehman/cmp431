package com.example.adaptiveview

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdaptiveViewApp(
  windowSize: WindowWidthSizeClass,
  modifier: Modifier = Modifier,
) {

  when (windowSize) {
    WindowWidthSizeClass.Compact -> {
      Text(text = "Compact Window")
    }

    WindowWidthSizeClass.Medium -> {
      Text(text = "Medium Window")
    }

    WindowWidthSizeClass.Expanded -> {
      Text(text = "Expanded Window")
    }

    else -> {
      Text(text = "OTHER")
    }
  }

}
