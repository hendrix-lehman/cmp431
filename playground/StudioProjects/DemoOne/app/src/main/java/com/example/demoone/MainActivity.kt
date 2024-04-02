package com.example.demoone

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.demoone.ui.theme.DemoOneTheme

val TAG = "DemoOne"

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.i(TAG, "onCreate")
    var viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
    setContent {
      DemoOneTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//          CounterView(count = 1)
          var count by remember { mutableStateOf(0) }
          Column {
            Text("Counter: $count")
            Button(onClick = {
              viewModel.add()
              count = viewModel.count
            }) {
              Text(text = "Add")
            }
          }
        }
      }
    }
  }

  override fun onStart() {
    super.onStart()
    Log.i(TAG, "onStart")
  }

  override fun onResume() {
    super.onResume()
    Log.i(TAG, "onResume")
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(TAG, "onDestroy")
  }
}

// ViewModel
// think of it as the thing between the View (User Interface) and the Model (Data)
// View (UI) <-----------> ViewModel <--------------> Model (Data)

@Composable
fun CounterView(count: Int) {
//  var counter by remember { mutableStateOf(0) }
  Column {
//    Text("Counter: $counter")
//    Button(onClick = { counter++ }) {
    Button(onClick = { }) {
      Text(text = "Add")
    }
  }
}
