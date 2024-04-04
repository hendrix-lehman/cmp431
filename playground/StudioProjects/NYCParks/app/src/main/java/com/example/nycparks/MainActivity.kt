package com.example.nycparks

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.nycparks.ui.NycParksApp
import com.example.nycparks.ui.theme.NYCParksTheme
import com.example.nycparks.util.TAG

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    Log.i(TAG, "MainActivity: onCreate creating NycParksApp content")
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent {
      NYCParksTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
        ) {
          NycParksApp()
        }
      }
    }
  }
}
