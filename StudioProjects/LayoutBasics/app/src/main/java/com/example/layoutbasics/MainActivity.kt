package com.example.layoutbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutbasics.ui.theme.LayoutBasicsTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      LayoutBasicsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        )
        {
          HelloClass()
        }
      }
    }
  }
}

@Composable
fun HappyMonday() {
  Text(text = "Happy Monday")
}

@Composable
fun HelloClass() {
  Column {

    Text(text = "Hello class!!!", color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 24.sp)
    HappyMonday()
  }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  LayoutBasicsTheme {
    HelloClass()
  }
}
