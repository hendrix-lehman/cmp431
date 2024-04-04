package com.example.viewmodeldemo

import HomePageViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodeldemo.pages.HomePage
import com.example.viewmodeldemo.pages.LuckyNumberCard
import com.example.viewmodeldemo.ui.theme.ViewModelDemoTheme

class MainActivity : ComponentActivity() {

  // (1)
  // simple ViewModel which DO NOT survive setting changes
//  private val homeViewModel = HomePageViewModel()


  // (2)
  // HomeViewModel extends ViewModel()
  // So, it survives setting changes
//  private val homeViewModel by viewModels<HomePageViewModel>()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ViewModelDemoTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//          HomePage()

          // (3) what-if HomePageViewModel requires constructor parameters like a repository
          // in that case, we need to create an instance of HomePageViewModel using a Factory
          val homeViewModel: HomePageViewModel = viewModel(factory = HomePageViewModel.Factory)
          LuckyNumberCard(number = homeViewModel.luckyNumber) {
//            Log.i(javaClass.simpleName, "click")
            homeViewModel.getLuckyNumber()
          }
        }
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
//    Log.i(javaClass.simpleName, "on destroy: lucky number still: ${homeViewModel.luckyNumber}")
  }
}


// An Android app has one or more Activities

// Each Activity can be broken down into small components
// and by components, I mean one or more @Composable functions

// Using @Composable functions, we can make up the content of a Screen (visible user area)

//